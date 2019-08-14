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
	public String civil(Model model) {
		System.out.println("civil");
		return "/Business/civil";
	}
	@RequestMapping(value = "/plant")
	public String plant(Model model) {
		System.out.println("plant");
		return "/Business/plant";
	}
}
