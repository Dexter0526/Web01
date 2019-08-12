package com.company.project.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.project.PCommand.PListCommand;
import com.company.project.PCommand.Pcommand;

@Controller
public class PatentController {
	Pcommand command;
	
	
	@RequestMapping(value = "/patent")
	public String patent(HttpServletRequest request, Model model) {
		System.out.println("patent");
		model.addAttribute("request", request);
		command = new PListCommand();
		command.execute(model);
		
		return "/Tech/patent";
	}
	
	@RequestMapping(value = "/patentWrite")
	public String patentWrite(Model model) {
		System.out.println("patent write view");
		
		return "Tech/patentWrite";
	}
	@RequestMapping(value = "/registration")
	public String registration(HttpServletRequest request, Model model) {
		System.out.println("등록 완료");
		
		
		return "/Tech/patent";
	}
}
