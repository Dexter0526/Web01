package com.company.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.project.BCommand.BCommand;
import com.company.project.BCommand.BListCommand;

@Controller
public class BusinessController {
	BCommand command;
	
	@RequestMapping(value = "/building")
	public String building(HttpServletRequest request, Model model) {
		System.out.println("building");
		model.addAttribute("request", request);
		HttpSession session2 = request.getSession();
		session2.setAttribute("table", "building");
		command = new BListCommand();
		command.execute(model);
		
		return "/Business/building";
	}
	@RequestMapping(value = "/civil")
	public String civil(HttpServletRequest request, Model model) {
		System.out.println("civil");
		model.addAttribute("request", request);
		HttpSession session2 = request.getSession();
		session2.setAttribute("table", "civil");
		command = new BListCommand();
		command.execute(model);
		return "/Business/civil";
	}
	@RequestMapping(value = "/plant")
	public String plant(HttpServletRequest request, Model model) {
		System.out.println("plant");
		model.addAttribute("request", request);
		HttpSession session2 = request.getSession();
		session2.setAttribute("table", "plant");
		command = new BListCommand();
		command.execute(model);
		return "/Business/plant";
	}
	@RequestMapping(value = "/businessTable")
	public String adminTable(Model model) {
		System.out.println("사업실적 리스트 뷰");
		
		return "/Business/businessTable";
	}
	@RequestMapping(value = "/businessWrite")
	public String businessWrite(Model model) {
		System.out.println("사업실적 등록 뷰");
		
		return "/Business/businessWrite";
	}
}
