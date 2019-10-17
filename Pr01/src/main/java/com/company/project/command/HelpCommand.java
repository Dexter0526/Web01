package com.company.project.command;

import com.company.project.dto.HelpDto;

public interface HelpCommand {
	public void sendEmail(HelpDto helpDto, String action);
}
