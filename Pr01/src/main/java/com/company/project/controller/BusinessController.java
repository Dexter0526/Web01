package com.company.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.project.BCommand.BCommand;
import com.company.project.BCommand.BListCommand;
import com.company.project.BCommand.BRegistrationCommand;
import com.company.project.BCommand.BUpdateCommand;
import com.company.project.BCommand.BUpdateViewCommand;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class BusinessController {
	BCommand command;
	
	@RequestMapping(value = "/building")
	public String building(HttpServletRequest request, Model model) {
		log.info("building");
		model.addAttribute("request", request);
		HttpSession session2 = request.getSession();
		session2.setAttribute("table", "building");
		command = new BListCommand();
		command.execute(model);
		
		return "/Business/building";
	}
	@RequestMapping(value = "/civil")
	public String civil(HttpServletRequest request, Model model) {
		log.info("civil");
		model.addAttribute("request", request);
		HttpSession session2 = request.getSession();
		session2.setAttribute("table", "civil");
		command = new BListCommand();
		command.execute(model);
		return "/Business/civil";
	}
	@RequestMapping(value = "/plant")
	public String plant(HttpServletRequest request, Model model) {
		log.info("plant");
		model.addAttribute("request", request);
		HttpSession session2 = request.getSession();
		session2.setAttribute("table", "plant");
		command = new BListCommand();
		command.execute(model);
		return "/Business/plant";
	}
	@RequestMapping(value = "/businessTable")
	public String adminTable(HttpServletRequest request, Model model) {
		log.info("사업실적 리스트 뷰");
		model.addAttribute("request", request);
		HttpSession session2 = request.getSession();
		int bResult = 0;
		session2.setAttribute("bResult", bResult);
		System.out.println("bResult : "+bResult);
		
		return "/Business/businessTable";
	}
	@RequestMapping(value="/besinessRegistration")
	public String besinessRegistration(HttpServletRequest request, Model model) {
		log.info("사업실적 등록");
		model.addAttribute("request", request);
		command = new BRegistrationCommand();
		command.execute(model);
		
		// 리스트 재실행
		command = new BListCommand();
		command.execute(model);
		
		return "/Business/businessTable";
	}
	@RequestMapping(value = "/businessUpdateView")
	public String businessUpdateView(HttpServletRequest request, Model model) {
		log.info("사업실적 수정");
		model.addAttribute("request", request);
		HttpSession session2 = request.getSession();
		command = new BUpdateViewCommand();
		command.execute(model);
		
		int bResult = 1;
		session2.setAttribute("bResult", bResult);
		
		return "/Business/businessTable";
	}
	@RequestMapping(value = "/besinessUpdate")
	public String besinessUpdate(HttpServletRequest request, Model model) {
		log.info("사업실적 수정완료");
		model.addAttribute("request", request);
		command = new BUpdateCommand();
		command.execute(model);
		
		// 리스트 재실행
		command = new BListCommand();
		command.execute(model);
		
		return "/Business/businessTable";
	}
	@RequestMapping(value ="/businessDelete")
	public String businessDelete(HttpServletRequest request, Model model) {
		log.info("사업실적 삭제완료");
		model.addAttribute("request", request);
		
		// 리스트 재실행
		command = new BListCommand();
		command.execute(model);
		return "/Business/businessTable";
	}
}
