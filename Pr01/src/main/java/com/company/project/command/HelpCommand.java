package com.company.project.command;

import com.company.project.dto.ConsultingDto;
import com.company.project.dto.HelpDto;

public interface HelpCommand {
	public void helpSendEmail(HelpDto helpDto, String action);
	
	public void consultingSendEmail(ConsultingDto consulting);
}
