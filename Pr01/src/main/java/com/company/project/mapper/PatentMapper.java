package com.company.project.mapper;

import java.util.List;

import com.company.project.dto.PatentDto;

public interface PatentMapper {
	public List<PatentDto> selectAllPatent();
	
	public void insertPatent(PatentDto pdto);
	
	public PatentDto getPatent(String patentNum);
	
	public void updatePatent(PatentDto pdto);
	
	public void deletePatent(String patentNum);
}
