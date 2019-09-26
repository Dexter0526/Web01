package com.company.project.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class IndexController {
	@RequestMapping(value = "/index")
	public String index(Model model) {
		log.info("index");
		return "index";
	}

	// 회사소개
	@RequestMapping(value = "/info")
	public String about(Model model) {
		log.info("info");
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
		log.info("futureTech");
		return "/Tech/futureTech";
	}
	
	// 직원 로그인 뷰
	@RequestMapping(value = "/log")
	public String log(Model model) {
		log.info("log");
		return "Log/log";
	}
	
}
