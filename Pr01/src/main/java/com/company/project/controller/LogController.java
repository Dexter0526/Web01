package com.company.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.project.MCommand.MDeleteCommand;
import com.company.project.MCommand.MJoinCommand;
import com.company.project.MCommand.MLogOutCommand;
import com.company.project.MCommand.MLogingCommand;
import com.company.project.MCommand.MUpdateCommand;
import com.company.project.MCommand.MUpdateViewCommand;
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
		
		HttpSession session2 = request.getSession();
		System.out.println(session2.getAttribute("result"));
		int result = (Integer) session2.getAttribute("result");
		if(result == 1 ) {
			return "index";
		}else {
			return "Log/log";
		}
	}
	@RequestMapping(value = "/logout")
	public String logout_process(HttpServletRequest request, Model model) {
		System.out.println("logout()");
		
		model.addAttribute("request", request);
		command = new MLogOutCommand();
		command.execute(model);
		
		return "index";
	}
	
	@RequestMapping(value = "/signup")
	public String singUp(Model model) {
		System.out.println("signUp");
		
		return "Log/signUp";
	}
	@RequestMapping(value = "/join")
	public String join(HttpServletRequest request, Model model) {
		System.out.println("회원가입");
		model.addAttribute("request", request);
		command = new MJoinCommand();
		command.execute(model);
		
		return "MemberView/memberView";
	}
	@RequestMapping(value = "/memberUpdateView")
	public String memberUpdateView(HttpServletRequest request, Model model) {
		System.out.println("회원 수정");
		model.addAttribute("request", request);
		command = new MUpdateViewCommand();
		command.execute(model);
		
		return "Log/memberUpdateView";
	}
	@RequestMapping(value = "/memberUpdate")
	public String memberUpdate(HttpServletRequest request, Model model) {
		System.out.println("수정 완료");
		model.addAttribute("request", request);
		command = new MUpdateCommand();
		command.execute(model);
		
		return "MemberView/memberIndexView";
	}
	@RequestMapping(value = "/memberDelete")
	public String memberDelete(HttpServletRequest request, Model model) {
		System.out.println("회원 삭제");
		model.addAttribute("request", request);
		command = new MDeleteCommand();
		command.execute(model);
		
		return "MemberView/memberIndexView";
	}
}
