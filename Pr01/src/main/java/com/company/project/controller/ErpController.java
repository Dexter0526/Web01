package com.company.project.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
//@AllArgsConstructor
@Controller
public class ErpController {

	
	@RequestMapping(value = "Analytics")
	public String Analytics(HttpServletRequest request, Model model) {
		log.info("pr_report");
		
		return "Erp/includeTest";
	}
	
}
