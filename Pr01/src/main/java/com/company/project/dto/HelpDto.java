package com.company.project.dto;

import java.util.Date;

import lombok.Data;

@Data
public class HelpDto {
	private int num;
	private String email;
	private String title;
	private String content;
	private Date reg_date;
	
	
}
