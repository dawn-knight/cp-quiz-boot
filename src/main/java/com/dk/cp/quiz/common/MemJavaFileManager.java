package com.dk.cp.quiz.common;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.nio.CharBuffer;
import java.util.HashMap;
import java.util.Map;

import javax.tools.FileObject;
import javax.tools.ForwardingJavaFileManager;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.JavaFileObject.Kind;
import javax.tools.SimpleJavaFileObject;

@SuppressWarnings("rawtypes")
public final class MemJavaFileManager extends ForwardingJavaFileManager {

	private final static String EXT = ".java";

	private Map<String, byte[]> classBytes;

	protected MemJavaFileManager(JavaFileManager arg0) {
		super(arg0);
		classBytes = new HashMap<>();
	}

	public Map<String, byte[]> getClassBytes() {
		return classBytes;
	}

	public void close() throws IOException {
		classBytes = null;
	}

	public void flush() throws IOException {
	}

	static URI toURI(String name) {
		File file = new File(name);
		if (file.exists()) {
			return file.toURI();
		} else {
			try {
				final StringBuilder newUri = new StringBuilder();
				newUri.append("mfm:///");
				newUri.append(name.replace('.', '/'));
				if (name.endsWith(EXT))
					newUri.replace(newUri.length() - EXT.length(),
							newUri.length(), EXT);
				return URI.create(newUri.toString());
			} catch (Exception exp) {
				return URI.create("mfm:///com/sun/script/java/java_source");
			}
		}
	}

	private static class StringInputBuffer extends SimpleJavaFileObject {
		final String code;

		StringInputBuffer(String fileName, String code) {
			super(toURI(fileName), Kind.SOURCE);
			this.code = code;
		}

		public CharBuffer getCharContent(boolean ignoreEncodingErrors) {
			return CharBuffer.wrap(code);
		}
	}

	private class ClassOutputBuffer extends SimpleJavaFileObject {
		private String name;

		ClassOutputBuffer(String name) {
			super(toURI(name), Kind.CLASS);
			this.name = name;
		}

		public OutputStream openOutputStream() {
			return new FilterOutputStream(new ByteArrayOutputStream()) {
				public void close() throws IOException {
					out.close();
					ByteArrayOutputStream bos = (ByteArrayOutputStream) out;
					classBytes.put(name, bos.toByteArray());
				}
			};
		}
	}

	public JavaFileObject getJavaFileForOutput(
			JavaFileManager.Location location, String className, Kind kind,
			FileObject sibling) throws IOException {
		if (kind == Kind.CLASS) {
			return new ClassOutputBuffer(className);
		} else {
			return super.getJavaFileForOutput(location, className, kind,
					sibling);
		}
	}

	static JavaFileObject makeStringSource(String fileName, String code) {
		return new StringInputBuffer(fileName, code);
	}
}
