package com.example.tuan7.models;

import java.util.Random;

public class EmailItemModel {
	String name;
	String subject;
	String content;
	String time;
	boolean isfav;
	int color;

	public EmailItemModel(String name, String subject, String content, String time , boolean isfav) {
		this.name = name;
		this.subject = subject;
		this.content = content;
		this.time = time;
		this.isfav = isfav;
		Random random = new Random();
		this.color = random.nextInt();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public boolean isIsfav() {
		return isfav;
	}

	public void setIsfav(boolean isfav) {
		this.isfav = isfav;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}
}
