package com.company.project.service;

import java.util.List;

import com.company.project.dto.g2bSearchDto;
import com.company.project.dto.g2bSearchRequestDto;


public interface ParseService {
	
	public List<g2bSearchDto> parseNara(g2bSearchRequestDto dto);
}
