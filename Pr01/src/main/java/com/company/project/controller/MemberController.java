package com.company.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {

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
