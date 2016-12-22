package com.dk.cp.quiz.model;

public class Answer {
	private int qid;
	private String character;
	private int level;

	public Answer(int qid, String character) {
		this.qid = qid;
		this.character = character;
	}

	public Answer(int qid, String character, int level) {
		this.qid = qid;
		this.character = character;
		this.level = level;
	}

	public int getQid() {
		return qid;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
}
