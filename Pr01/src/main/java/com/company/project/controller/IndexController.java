package com.company.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping(value = "/index")
	public String index(Model model) {
		System.out.println("index");
		System.out.println("실행");
		return "index";
	}

	// 회사소개
	@RequestMapping(value = "/info")
	public String about(Model model) {
		System.out.println("info");
		return "About/about";
	}
	
	// 사업분야
	@RequestMapping(value = "/business")
	public String business(Model model) {
		System.out.println("business");
		return "Business/building";
	}
	
	// 기술분야
	@RequestMapping(value = "/futureTech")
	public String futureTech(Model model) {
		System.out.println("futureTech");
		return "/Tech/futureTech";
	}
	
	// 홍보센터
	@RequestMapping(value = "/news")
	public String news(Model model) {
		System.out.println("news");
		return "/Promotion/news";
	}
	
	// 직원 로그인 뷰
	@RequestMapping(value = "/log")
	public String log(Model model) {
		System.out.println("log");
		return "Log/log";
	}
	
	// 고객센터
	@RequestMapping(value = "/contact")
	public String contact(Model model) {
		System.out.println("/contact");
		return "/Contact/contact";
	}

}
