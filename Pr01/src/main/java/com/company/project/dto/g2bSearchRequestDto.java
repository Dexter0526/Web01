package com.company.project.dto;

import lombok.Data;

@Data
public class g2bSearchRequestDto {
	private String ServiceKey;
	private String pageNo;
	private String numOfRows;
	private String inqryDiv;
	private String inqryBgnDt;
	private String inqryEndDt;
	private String bidNtceNo;
	
	public g2bSearchRequestDto() {
		this("?serviceKey=9s4gRft8gnWr6fo6gnxD6UXBzHj5gLGjGfllSuazFkendirH%2FyPbiZ7uirB2ZzwaWcC87qQChsI5w2t20BSnwA%3D%3D",
				"1",
				"20",
				"1",
				"201910010000",
				"201911032359");
	}


	public g2bSearchRequestDto(String serviceKey, String pageNo, String numOfRows, String inqryDiv, String inqryBgnDt,
			String inqryEndDt) {
		this.ServiceKey = serviceKey;
		this.pageNo = pageNo;
		this.numOfRows = numOfRows;
		this.inqryDiv = inqryDiv;
		this.inqryBgnDt = inqryBgnDt;
		this.inqryEndDt = inqryEndDt;
	}
	
	
}
