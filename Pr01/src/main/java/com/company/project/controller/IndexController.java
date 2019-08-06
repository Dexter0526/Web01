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
	@RequestMapping(value = "/about")
	public String about(Model model) {
		System.out.println("about");
		return "About/about";
	}
	
	// 사업분야
	@RequestMapping(value = "/business")
	public String contact(Model model) {
		System.out.println("contact");
		return "Business/building";
	}
	@RequestMapping(value = "/business/building")
	public String building(Model model) {
		System.out.println("business/building()");
		return "/Business/building";
	}
	@RequestMapping(value = "/business/civil")
	public String civil(Model model) {
		System.out.println("/business/civil");
		return "/Business/civil";
	}
	@RequestMapping(value = "/business/plant")
	public String plant(Model model) {
		System.out.println("/business/plant");
		return "/Business/plant";
	}
	
	// 기술분야
	@RequestMapping(value = "/tech/construction")
	public String construction(Model model) {
		System.out.println("/tech/construction");
		return "/Tech/construction";
	}
	@RequestMapping(value = "/tech/environment")
	public String environment(Model model) {
		System.out.println("/tech/environment");
		return "/Tech/environment";
	}
	@RequestMapping(value = "/tech/futureTech")
	public String futureTech(Model model) {
		System.out.println("/tech/futureTech");
		return "/Tech/futureTech";
	}
	@RequestMapping(value = "/tech/patent")
	public String patent(Model model) {
		System.out.println("/tech/patent");
		return "/Tech/patent";
	}
	@RequestMapping(value = "/tech/portfolio")
	public String portfolio(Model model) {
		System.out.println("/tech/portfolio");
		return "/Tech/portfolio";
	}
	
	// 직원 로그인
	@RequestMapping(value = "/log")
	public String log(Model model) {
		System.out.println("log");
		return "Log/log";
	}

}
