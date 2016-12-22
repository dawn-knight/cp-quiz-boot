package com.dk.cp.quiz.model;

import java.util.Calendar;

public class AnswerFromUser {
	private int uid;
	private int qid;
	private int choice;
	private String extra;
	private Calendar startTime;
	private Calendar endTime;
	private Calendar endTime4Extra;

	public AnswerFromUser(int uid, int qid, int choice, String extra,
			Calendar startTime, Calendar endTime, Calendar endTime4Extra) {
		this.uid = uid;
		this.qid = qid;
		this.choice = choice;
		this.extra = extra;
		this.startTime = startTime;
		this.endTime = endTime;
		this.endTime4Extra = endTime4Extra;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getQid() {
		return qid;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}

	public int getChoice() {
		return choice;
	}

	public void setChoice(int choice) {
		this.choice = choice;
	}

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

	public Calendar getStartTime() {
		return startTime;
	}

	public void setStartTime(Calendar startTime) {
		this.startTime = startTime;
	}

	public Calendar getEndTime() {
		return endTime;
	}

	public void setEndTime(Calendar endTime) {
		this.endTime = endTime;
	}

	public Calendar getEndTime4Extra() {
		return endTime4Extra;
	}

	public void setEndTime4Extra(Calendar endTime4Extra) {
		this.endTime4Extra = endTime4Extra;
	}
}
