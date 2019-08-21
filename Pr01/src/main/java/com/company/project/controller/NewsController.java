package com.company.project.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.project.NCommand.NCommand;
import com.company.project.NCommand.NListCommand;

@Controller
public class NewsController {
	NCommand command;
	
	@RequestMapping(value="/news")
	public String news(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		command = new NListCommand();
		command.execute(model);
		
		return "/Promotion/news";
	}
	
	@RequestMapping(value="/newsRegistration")
	public String newsRegistration() {
		
		return "/Promotion/news";
	}
}
