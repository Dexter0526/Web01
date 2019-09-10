package com.company.project.command;

import org.springframework.ui.Model;

public interface NewsCommand {
	public void selectAllNewsWithPaging(Model model);
}
