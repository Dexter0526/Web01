package com.company.project.service;


import org.springframework.ui.Model;

import com.company.project.dto.ConsultingDto;
import com.company.project.dto.HelpDto;

public interface HelpService {
	
	public void selectAllHelpWithPaging(Model model);
	
	public void insertHelp(HelpDto helpDto);
	
	public void updateHelp(HelpDto helpDto);
	
	public void deleteHelp(int num);
	
	public void getHelp(int num, Model model);
	
	public void getConsulting(int num, Model model);
	
	public void insertConsulting(ConsultingDto consulting);
	
}
