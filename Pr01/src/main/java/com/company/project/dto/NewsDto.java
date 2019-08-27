package com.company.project.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class NewsDto {
	private int num;
	private String title;
	private String content;
	private int count;
	private Timestamp regDate;
	
}
