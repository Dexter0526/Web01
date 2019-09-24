package com.company.project.command;

import org.springframework.ui.Model;

public interface MemberCommand {
	public void logingCommand(Model model);
	
	public void logoutCommand(Model model);
	
//	public void insertCommand(Model model);
	
	public void selectAllMemberWithPaging(Model model);
	
	public void selectSearchAllMemberWithPaging(Model model);
}
