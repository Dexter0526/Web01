package com.company.project.dto;

import lombok.Data;

@Data
public class Criteria {

	private int pageNum;
	private int amount;
	
	public Criteria() {
		this(1,10);
	}
	
	public Criteria(int pageNum) {
		this.pageNum = pageNum;
		this.amount = 20;
	}

	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	
}
