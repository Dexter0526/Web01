package com.company.project.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.project.PCommand.PDeleteCommand;
import com.company.project.PCommand.PListCommand;
import com.company.project.PCommand.PRegistrationCommand;
import com.company.project.PCommand.PUpdateCommand;
import com.company.project.PCommand.PUpdateViewCommand;
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
		model.addAttribute("request", request);
		command = new PRegistrationCommand();
		command.execute(model);
		
		// 리스트 재실행
		command = new PListCommand();
		command.execute(model);
		
		return "/Tech/patent";
	}
	@RequestMapping(value = "/patentUpdateView")
	public String patentUpdateView(HttpServletRequest request, Model model) {
		System.out.println("patent update view");
		model.addAttribute("request", request);
		command = new PUpdateViewCommand();
		command.execute(model);
		
		return "Tech/patentUpdateView";
	}
	@RequestMapping(value = "/patentUpdate")
	public String patentUpdate(HttpServletRequest request, Model model) {
		System.out.println("수정 완료");
		model.addAttribute("request", request);
		command = new PUpdateCommand();
		command.execute(model);
		
		return "index";
	}
	@RequestMapping(value = "/patentDelete")
	public String patentDelete(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		command = new PDeleteCommand();
		command.execute(model);
		
		return "index";
	}
}
