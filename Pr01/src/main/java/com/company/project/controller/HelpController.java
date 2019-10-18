package com.company.project.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.project.command.MemberCommand;
import com.company.project.dto.ConsultingDto;
import com.company.project.dto.Criteria;
import com.company.project.dto.HelpDto;
import com.company.project.dto.MemberDto;
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
		HttpSession session2 = request.getSession();
		
		// 리스트 실행
		service.selectAllHelpWithPaging(model);
		
		if(session2.getAttribute("admin") == null) {
			return "/Help/help";
		}else if(((MemberDto) session2.getAttribute("mdto")).getAdmin() == 2) {
			return "/Help/help";
		}else {
			return "Erp/Consulting/ConsultingView";
		}
		
	}
	
	@RequestMapping(value = "helpLog")
	public String helpLog(Criteria cri, HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		model.addAttribute("cri", cri);
		HttpSession session2 = request.getSession();
		command.logingCommand(model);
		
		// 리스트 실행
		service.selectAllHelpWithPaging(model);
		
		if(session2.getAttribute("admin") == null) {
			return "/Help/help";
		}else if(((int) session2.getAttribute("admin")) == 2) {
			return "/Help/help";
		}else {
			return "Erp/Consulting/ConsultingView";
		}
	}
	
	@RequestMapping(value = "helpInsert")
	public String helpInsert(Criteria cri, HelpDto helpDto, HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		model.addAttribute("cri", cri);
		
		service.insertHelp(helpDto);
		
		// 리스트 실행
		service.selectAllHelpWithPaging(model);
		
		return "/Help/help";
	}
	
	@RequestMapping(value = "helpDelete")
	public String helpDelete(Criteria cri, int num, HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		model.addAttribute("cri", cri);
		HttpSession session2 = request.getSession();
		service.deleteHelp(num);
		
		// 리스트 실행
		service.selectAllHelpWithPaging(model);
		
		if(((MemberDto) session2.getAttribute("mdto")).getAdmin() == 2) {
			return "/Help/help";
		}else {
			return "Erp/Consulting/ConsultingView";
		}
	}
	
	@RequestMapping(value = "helpGet")
	public String helpGet(Criteria cri, int num, HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		model.addAttribute("cri", cri);
		HttpSession session2 = request.getSession();		
		
		service.getHelp(num, model);
		service.getConsulting(num, model);

		model.addAttribute("help", mapper.getHelp(num));
		model.addAttribute("consulting", mapper.getConsulting(num));
		// 리스트 실행
		service.selectAllHelpWithPaging(model);
		
		log.info("help 세션값 : ???" + session2.getAttribute("help"));
		
		if(((MemberDto) session2.getAttribute("mdto")).getAdmin() == 2) {
			return "/Help/help";
		}else {
			return "Erp/Consulting/ConsultingGet";
		}
		
	}
	
	@RequestMapping(value = "helpUpdateView")
	public String helpUpdateView(Criteria cri, int num, HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		model.addAttribute("cri", cri);
		
		service.getHelp(num, model);
		
		return "/Help/helpUpdateView";
	}
	
	@RequestMapping(value = "helpUpdate")
	public String helpUpdate(Criteria cri, HelpDto helpDto, HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		model.addAttribute("cri", cri);
		service.updateHelp(helpDto);
		
		// 리스트 실행
		service.selectAllHelpWithPaging(model);
		
		return "/Help/help";
	}
	
	@RequestMapping(value = "consultingInsert")
	public String consultingInsert(Criteria cri, ConsultingDto consultingDto, HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		model.addAttribute("cri", cri);
		
		service.insertConsulting(consultingDto);
		
		// 리스트 실행
		service.selectAllHelpWithPaging(model);
		
		return "Erp/Consulting/ConsultingGet";
	}
}
