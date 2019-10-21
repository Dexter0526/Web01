package com.company.project.service;


import java.util.List;

import org.springframework.ui.Model;

import com.company.project.dto.ConsultingDto;
import com.company.project.dto.Criteria;
import com.company.project.dto.HelpDto;
import com.company.project.dto.MemberDto;
import com.company.project.dto.pageDto;

public interface HelpService {
	
	public List<HelpDto> selectAllHelpWithPaging(Criteria cri, MemberDto mdto, int result);
	
	public pageDto pageMaker(Criteria cri, MemberDto mdto);
	
	public void insertHelp(HelpDto helpDto);
	
	public void updateHelp(HelpDto helpDto);
	
	public void deleteHelp(int num);
	
	public HelpDto getHelp(int num);
	
	public ConsultingDto getConsulting(int num);
	
	public void insertConsulting(ConsultingDto consulting);
	
}
