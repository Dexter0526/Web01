package com.company.project.dto;

public class BusinessDto {
	private int num;
	private String title;
	private String content;
	private String field;
	
	public BusinessDto() {
		// TODO Auto-generated constructor stub
	}
	
	public BusinessDto(int num, String title, String content, String field) {
		super();
		this.num = num;
		this.title = title;
		this.content = content;
		this.field = field;
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
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}

	@Override
	public String toString() {
		return "BusinessDto [num=" + num + ", title=" + title + ", content=" + content + ", field=" + field + "]";
	}
	
	
}
