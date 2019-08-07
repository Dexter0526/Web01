package com.company.project.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.project.MCommand.MListCommand;
import com.company.project.MCommand.Mcommand;

@Controller
public class MemberController {
	Mcommand command;
	
	// 멤버 설정뷰(마스터 권한)
	@RequestMapping(value = "/memberView")
	public String memberView(HttpServletRequest request, Model model) {
		System.out.println("유저 계정 접근 권한");
		model.addAttribute("request", request);
		command = new MListCommand();
		command.execute(model);
		return "MemberView/memberView";
	}
	
	// ERP뷰
	@RequestMapping(value = "/memberIndexView")
	public String member_index_view(Model model) {
		System.out.println("member index view");
		
		return "MemberView/memberIndexView";
	}
	@RequestMapping(value = "/contract")
	public String member_contract(Model model) {
		System.out.println("contract view");
		
		return "MemberView/MemberBody/contract";
	}
	
	
	
}
