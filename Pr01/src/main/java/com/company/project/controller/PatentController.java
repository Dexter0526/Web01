package com.company.project.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.project.dto.PatentDto;
import com.company.project.mapper.PatentMapper;
import com.company.project.service.PatentService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@AllArgsConstructor
public class PatentController {
	
	private PatentService service;
	private PatentMapper mapper;
	
	@RequestMapping(value = "/patent")
	public String patent(HttpServletRequest request, Model model) {
		log.info("patent");
		model.addAttribute("request", request);
		service.selectAllPatent(model);
		
		return "/Tech/patent";
	}
	
	@RequestMapping(value = "/patentWrite")
	public String patentWrite(Model model) {
		log.info("patent write view");
		
		return "Tech/patentWrite";
	}
	@RequestMapping(value = "/registration")
	public String registration(PatentDto pdto, HttpServletRequest request, Model model) {
		log.info("등록 완료");
		model.addAttribute("request", request);
		mapper.insertPatent(pdto);
		
		// 리스트 재실행
		service.selectAllPatent(model);
		
		return "/Tech/patent";
	}
	@RequestMapping(value = "/patentUpdateView")
	public String patentUpdateView(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		service.updateViewPatent(model);
		
		return "Tech/patentUpdateView";
	}
	@RequestMapping(value = "/patentUpdate")
	public String patentUpdate(PatentDto pdto, HttpServletRequest request, Model model) {
		System.out.println("수정 완료");
		model.addAttribute("request", request);
		mapper.updatePatent(pdto);
		
		return "index";
	}
	@RequestMapping(value = "/patentDelete")
	public String patentDelete(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		
		mapper.deletePatent(request.getParameter("patentNum"));
		
		return "index";
	}
}
