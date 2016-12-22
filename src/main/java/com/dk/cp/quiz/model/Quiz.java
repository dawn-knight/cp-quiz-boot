package com.dk.cp.quiz.model;

public class Quiz {
	private int qid;
	private String topic;
	private int type;
	private String[] options;
	private String extra;

	public Quiz(int qid, String topic, int type, String[] options,
			String extra) {
		super();
		this.qid = qid;
		this.topic = topic;
		this.type = type;
		this.options = options;
		this.extra = extra;
	}

	public int getQid() {
		return qid;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String[] getOptions() {
		return options;
	}

	public void setOptions(String[] options) {
		this.options = options;
	}

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

}
