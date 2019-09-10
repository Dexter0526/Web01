package com.company.project.dto;

import java.util.Date;

import lombok.Data;

@Data
public class NewsDto {
	private int num;
	private String title;
	private String content;
	private int readcount;
	private Date reg_Date;
	
}
