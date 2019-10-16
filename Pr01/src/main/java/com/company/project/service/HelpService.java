package com.company.project.service;


import org.springframework.ui.Model;

import com.company.project.dto.HelpDto;

public interface HelpService {
	
	public void selectAllHelpWithPaging(Model model);
	
	public void insertHelp(HelpDto helpDto);
	
	public void updateHelp(HelpDto helpDto);
	
	public void deleteHelp(int num);
}
