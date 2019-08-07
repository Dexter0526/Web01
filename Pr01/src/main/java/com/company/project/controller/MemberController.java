package com.company.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	// 멤버 설정뷰(마스터 권한)
	@RequestMapping(value = "/memberView")
	public String memberView(Model model) {
		System.out.println("유저 계정 접근 권한");
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
