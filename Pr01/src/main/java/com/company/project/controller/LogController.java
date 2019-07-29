package com.company.project.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.project.MCommand.MLogingCommand;
import com.company.project.MCommand.Mcommand;

@Controller
public class LogController {
Mcommand command;
	
	@RequestMapping(value = "/login")
	public String log_process(HttpServletRequest request, Model model) {
		System.out.println("login()");
		
		model.addAttribute("request", request);
		command = new MLogingCommand();
		command.execute(model);
		
		return "Test";
	}

}
