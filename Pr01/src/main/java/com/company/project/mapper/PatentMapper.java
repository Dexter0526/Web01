package com.company.project.mapper;

import java.util.List;

import com.company.project.dto.PatentDto;

public interface PatentMapper {
	public List<PatentDto> selectAllPatent();
	
	public int insertPatent(PatentDto pdto);
	
	public PatentDto getPatent(String patentNum);
	
	public int updatePatent(PatentDto pdto);
	
	public int deletePatent(String patentNum);
}
