package com.company.project.dto;

import java.sql.Timestamp;

public class NewsDto {
	private int num;
	private String title;
	private String content;
	private int count;
	private Timestamp regDate;
	
	public NewsDto() {
		// TODO Auto-generated constructor stub
	}
	
	public NewsDto(int num, String title, String content, int count, Timestamp regDate) {
		super();
		this.num = num;
		this.title = title;
		this.content = content;
		this.count = count;
		this.regDate = regDate;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Timestamp getRegDate() {
		return regDate;
	}
	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "NewsDto [num=" + num + ", title=" + title + ", content=" + content + ", count=" + count + ", regDate="
				+ regDate + "]";
	}
}
