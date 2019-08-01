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

	@RequestMapping(value = "/about")
	public String about(Model model) {
		System.out.println("about");
		return "About/about";
	}
	@RequestMapping(value = "/contact")
	public String contact(Model model) {
		System.out.println("contact");
		return "Contact/contact";
	}
	@RequestMapping(value = "/log")
	public String log(Model model) {
		System.out.println("log");
		return "Log/log";
	}

	@RequestMapping(value = "/join")
	public String join(Model model) {
		System.out.println("join");
		return "Log/join";
	}
}
