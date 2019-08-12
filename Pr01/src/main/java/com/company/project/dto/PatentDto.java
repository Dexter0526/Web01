package com.company.project.dto;

public class PatentDto {
	private int num;
	private String patentNum;
	private String title;
	private String content;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getPatentNum() {
		return patentNum;
	}
	public void setPatentNum(String patentNum) {
		this.patentNum = patentNum;
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
	public PatentDto(int num, String patentNum, String title, String content) {
		super();
		this.num = num;
		this.patentNum = patentNum;
		this.title = title;
		this.content = content;
	}
	
	public PatentDto() {
		// TODO Auto-generated constructor stub
	}
}
