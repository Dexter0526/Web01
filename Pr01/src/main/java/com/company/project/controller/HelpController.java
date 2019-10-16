package com.company.project.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.project.command.MemberCommand;
import com.company.project.dto.Criteria;
import com.company.project.dto.HelpDto;
import com.company.project.mapper.HelpMapper;
import com.company.project.service.HelpService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@AllArgsConstructor
public class HelpController {
	
	private MemberCommand command;
	private HelpMapper mapper;
	private HelpService service;
	
	// 고객센터
	@RequestMapping(value = "/help")
	public String help(Criteria cri, HttpServletRequest request, Model model) {
		log.info("Help");
		model.addAttribute("request", request);
		model.addAttribute("cri", cri);
		// 리스트 실행
		service.selectAllHelpWithPaging(model);
		return "/Help/help";
	}
	
	@RequestMapping(value = "helpLog")
	public String helpLog(Criteria cri, HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		model.addAttribute("cri", cri);
		command.logingCommand(model);
		
		// 리스트 실행
		service.selectAllHelpWithPaging(model);
		return "/Help/help";
	}
	
	@RequestMapping(value = "helpInsert")
	public String helpInsert(HelpDto helpDto, HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		
		service.insertHelp(helpDto);
		
		// 리스트 실행
		service.selectAllHelpWithPaging(model);
		
		return "/Help/help";
	}
	
	@RequestMapping(value = "helpDelete")
	public String helpDelete(int num, HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
	
		service.deleteHelp(num);
		
		// 리스트 실행
		service.selectAllHelpWithPaging(model);
				
		return "/Help/help";
	}
	
	@RequestMapping(value = "helpGet")
	public String helpGet(int num, HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		
		mapper.getHelp(num);
		
		// 리스트 실행
		service.selectAllHelpWithPaging(model);
		
		return "/Help/help";
	}
	
	@RequestMapping(value = "helpUpdateView")
	public String helpUpdateView(int num, HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		model.addAttribute("help", mapper.getHelp(num));
		
		return "/Help/helpUpdateView";
	}
	
	@RequestMapping(value = "helpUpdate")
	public String helpUpdate(HelpDto helpDto, HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		
		service.updateHelp(helpDto);
		
		// 리스트 실행
		service.selectAllHelpWithPaging(model);
		
		return "/Help/help";
	}
}
