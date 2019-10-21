package com.company.project.service;

import java.util.List;

import com.company.project.dto.PatentDto;

public interface PatentService {
	public List<PatentDto> selectAllPatent();
	
	public PatentDto updateViewPatent(String patentNum);
	
	public int insertPatent(PatentDto pdto);
	
	public int updatePatent(PatentDto pdto);
	
	public int deletePatent(String patentNum);
}
