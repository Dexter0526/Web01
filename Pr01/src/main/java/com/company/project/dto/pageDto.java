package com.company.project.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class pageDto {
	
	private int startPage;
	private int endPage;
	private boolean prev, next;
	
	private int total;
	private Criteria cri;
	
	public pageDto(Criteria cri, int total) {
		
		this.cri = cri;
		this.total = total;
	
		this.endPage = (int) (Math.ceil(cri.getPageNum() / 5.0)) * 5;
		this.startPage = this.endPage - 4;
		
	}
	
}
