package com.company.project.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.project.dto.Criteria;
import com.company.project.dto.g2bSearchDto;
import com.company.project.dto.g2bSearchRequestDto;
import com.company.project.dto.pageDto;
import com.company.project.service.ParseService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
//@AllArgsConstructor
@Controller
@AllArgsConstructor
public class ErpController {
	
	private ParseService service;
	
	@RequestMapping(value = "Analytics")
	public String Analytics(HttpServletRequest request, Model model) {
		log.info("pr_report");
		
		return "Erp/pr_report";
	}
	
	@RequestMapping(value = "Nara")
	public String Nara(g2bSearchRequestDto dto, Criteria cri, Model model, HttpServletRequest request) {
		
		List<g2bSearchDto> nara = service.parseNara(dto);
		
		model.addAttribute("nara", nara);
		model.addAttribute("g2bDto", dto);
		model.addAttribute("pageMaker", new pageDto(cri, nara.size()));
		
		return "Erp/Nara/NaraIndex";
	}
}
