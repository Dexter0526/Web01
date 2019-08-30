package com.company.project.controller;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.project.MCommand.MLogingCommand;
import com.company.project.MCommand.Mcommand;
import com.company.project.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@AllArgsConstructor
public class MemberController {
	
	@Setter(onMethod_ = @Autowired)
	private MemberService service;
	
	@Setter(onMethod_ = @Autowired)
	private MLogingCommand logingCommand;

	// 멤버 설정뷰(마스터 권한)
	@RequestMapping(value = "/memberView")
	public String memberView(Model model) {
		log.info("멤버 뷰");
		model.addAttribute("memberList", service.selectAllMember());
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
	
	// 로그인
	@RequestMapping(value = "/login")
	public String log_process(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		// 커맨드 사용(@Component)
		logingCommand.execute(model);
		Map<String, Object> map = model.asMap();
		int result = (Integer) map.get("result");
		
		// service만 사용
//		String email = request.getParameter("email");
//		String pwd = request.getParameter("pwd");
//		int result = service.userCheck(email, pwd);
		
//		// service(내부 함수 다중 사용)
//		service.loging(model);
//		int result = (int) map.get("result");
		
		if(result == 1 ) {
			return "index";
		}else {
			return "Log/log";
		}
	}
}
