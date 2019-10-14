package com.company.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.project.command.MemberCommand;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
public class HelpController {
	
	private MemberCommand command;
	
	// 고객센터
	@RequestMapping(value = "/help")
	public String contact(HttpServletRequest request, Model model) {
		log.info("Help");
		model.addAttribute("request", request);
		return "/Help/help";
	}
	
	@RequestMapping(value="helpLog")
	public String helpLog(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		
		command.logingCommand(model);
		
		return "/Help/help";
	}
	
}
