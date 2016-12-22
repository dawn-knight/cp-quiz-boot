package com.dk.cp.quiz.common;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

public class MemClassCompiler {
	private JavaCompiler compiler;
	private StandardJavaFileManager stdManager;

	public MemClassCompiler() {
		compiler = ToolProvider.getSystemJavaCompiler();
		if (compiler == null) {
			throw new RuntimeException(
					"Could not get Java compiler. Please, ensure that JDK is used instead of JRE.");
		}
		stdManager = compiler.getStandardFileManager(null, null, null);
	}

	public Map<String, byte[]> compile(String fileName, String source) {
		return compile(fileName, source, new PrintWriter(System.err), null,
				null);
	}

	private Map<String, byte[]> compile(String fileName, String source,
			Writer err, String sourcePath, String classPath) {
		// to collect errors, warnings etc.
		DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();

		// create a new memory JavaFileManager
		MemJavaFileManager fileManager = new MemJavaFileManager(stdManager);

		// prepare the compilation unit
		List<JavaFileObject> compUnits = new ArrayList<JavaFileObject>(1);
		compUnits.add(fileManager.makeStringSource(fileName, source));

		return compile(compUnits, fileManager, err, sourcePath, classPath);
	}

	private Map<String, byte[]> compile(final List<JavaFileObject> compUnits,
			final MemJavaFileManager fileManager, Writer err,
			String sourcePath, String classPath) {
		// to collect errors, warnings etc.
		DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();

		// javac options
		List<String> options = new ArrayList<String>();
		options.add("-Xlint:all");
		// options.add("-g:none");
		options.add("-deprecation");
		if (sourcePath != null) {
			options.add("-sourcepath");
			options.add(sourcePath);
		}

		if (classPath != null) {
			options.add("-classpath");
			options.add(classPath);
		}

		// create a compilation task
		CompilationTask task = compiler.getTask(err, fileManager, diagnostics,
				options, null, compUnits);

		if (task.call() == false) {
			PrintWriter perr = new PrintWriter(err);
			for (Diagnostic diagnostic : diagnostics.getDiagnostics()) {
				perr.println(diagnostic);
			}
			perr.flush();
			return null;
		}

		Map<String, byte[]> classBytes = fileManager.getClassBytes();
		try {
			fileManager.close();
		} catch (IOException exp) {
		}

		return classBytes;
	}
}
