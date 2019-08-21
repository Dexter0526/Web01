package com.company.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.project.NCommand.NCommand;
import com.company.project.NCommand.NDeleteCommand;
import com.company.project.NCommand.NGetCommand;
import com.company.project.NCommand.NListCommand;
import com.company.project.NCommand.NRegistrationCommand;
import com.company.project.NCommand.NUpdateCommand;

@Controller
public class NewsController {
	NCommand command;
	
	@RequestMapping(value="/news")
	public String news(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		HttpSession session2 = request.getSession();
		session2.removeAttribute("nresult");
		command = new NListCommand();
		command.execute(model);
		return "/Promotion/news";
	}
	
	@RequestMapping(value="/newsRegistration")
	public String newsRegistration(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		command = new NRegistrationCommand();
		command.execute(model);
		
		// 리스트 재실행
		command = new NListCommand();
		command.execute(model);
		
		return "/Promotion/news";
	}
	@RequestMapping(value="/getNews")
	public String getNews(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		command = new NGetCommand();
		command.execute(model);
		
		return "/Promotion/news";
	}
	@RequestMapping(value="/newsUpdate")
	public String newsUpdate(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		
		command = new NUpdateCommand();
		command.execute(model);
		
		// 리스트 재실행
		command = new NListCommand();
		command.execute(model);
		
		return "/Promotion/news";
	}
	
	@RequestMapping(value="/newsDelete")
	public String newsDelete(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		command = new NDeleteCommand();
		command.execute(model);
		
		// 리스트 재실행
		command = new NListCommand();
		command.execute(model);
		return "/Promotion/news";
	}
	
}
