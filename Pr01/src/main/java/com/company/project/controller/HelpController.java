package com.company.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class HelpController {
	// 고객센터
	@RequestMapping(value = "/help")
	public String contact(HttpServletRequest request, Model model) {
		log.info("Help");
		model.addAttribute("request", request);
		HttpSession session2 = request.getSession();

		if(session2.getAttribute("result") != null) {
			if((int) session2.getAttribute("result") == 1) {
				return "/Help/help";
			}else {
				return "Log/log";
			}
		}else {
			return "Log/log";
		}
		
	}
}
