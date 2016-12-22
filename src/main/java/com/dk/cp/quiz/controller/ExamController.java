package com.dk.cp.quiz.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dk.cp.quiz.common.MemClassCompiler;
import com.dk.cp.quiz.common.MemClassLoader;
import com.dk.cp.quiz.dao.ChoiceDraftMapper;
import com.dk.cp.quiz.model.ChoiceDraft;
import com.dk.cp.quiz.model.Quiz;
import com.dk.cp.quiz.model.Tests;

@RestController
@RequestMapping("exam")
public class ExamController {
	private static String javaFileInStrHeader = "public class ExamFromWeb {";
	private static String javaFileInStrFooter = "}";
	private static MemClassCompiler compiler = new MemClassCompiler();
	
	@Autowired
	private ChoiceDraftMapper cdMapper;

	@RequestMapping("precompile")
	public String precompile(@RequestBody String req)
			throws ClassNotFoundException, NoSuchMethodException,
			SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException,
			InstantiationException {
		Map<String, byte[]> classBytes = compiler.compile("ExamFromWeb.java",
				javaFileInStrHeader + req.toString() + javaFileInStrFooter);
		MemClassLoader memClassLoader = new MemClassLoader(classBytes);
		Class clazz = memClassLoader.loadClass("ExamFromWeb");
		clazz.getMethod("printSth").invoke(clazz.newInstance());
		return req.toString();
	}
	
	@RequestMapping("tests")
	public Tests getQuestions() {
		List<Quiz> testItems = new ArrayList<Quiz>();
		Quiz q1 = new Quiz(1, "你是男是女", 1, new String[]{"男","女"}, null);
		Quiz q2 = new Quiz(2, "你懂java吗", 1, new String[]{"懂","不懂","java是什么鬼"}, null);
		testItems.add(q1);
		testItems.add(q2);
		Tests tests = new Tests();
		tests.setItems(testItems);
		return tests;
	}
	
	private String tmp;
	
	@RequestMapping("submit")
	public void takeSubmission(@RequestBody String submission) {
		tmp = submission;
	}
	
	@RequestMapping("transcript")
	public String announceResult() {
		return tmp;
	}
	
	@RequestMapping("proposal")
	public void proposal() {
		ChoiceDraft cd = new ChoiceDraft();
		cd.setId(1);
		cd.setDrafterId(1);
		cd.setCreatedTime(new Date());
		cd.setStatus(true);
		cd.setLevel((byte) 1);
		cd.setImageId(1);
		cd.setQuestion("first question");
		cdMapper.insert(cd);
	}
}
