package com.company.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.project.command.BusinessCommand;
import com.company.project.dto.BusinessDto;
import com.company.project.service.BusinessService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@AllArgsConstructor
public class BusinessController {

	private BusinessService service;
	private BusinessCommand command;
	
	@RequestMapping(value = "/building")
	public String building(HttpServletRequest request, Model model) {
		log.info("building");
		model.addAttribute("request", request);
		service.selectAllBusiness("building", model);
		
		return "/Business/building";
	}
	
	@RequestMapping(value = "/civil")
	public String civil(HttpServletRequest request, Model model) {
		log.info("civil");
		model.addAttribute("request", request);
		service.selectAllBusiness("civil", model);
		return "/Business/civil";
	}
	
	@RequestMapping(value = "/plant")
	public String plant(HttpServletRequest request, Model model) {
		log.info("plant");
		model.addAttribute("request", request);
		service.selectAllBusiness("plant", model);
		return "/Business/plant";
	}
	
	@RequestMapping(value = "/businessTable")
	public String adminTable(HttpServletRequest request, Model model) {
		log.info("사업실적 리스트 뷰");
		model.addAttribute("request", request);
		HttpSession session2 = request.getSession();
		int bResult = 0;
		session2.setAttribute("bResult", bResult);
		
		return "/Business/businessTable";
	}
	
	@RequestMapping(value="/besinessRegistration")
	public String besinessRegistration(BusinessDto bdto, HttpServletRequest request, Model model) {
		log.info("사업실적 등록");
		model.addAttribute("request", request);
		HttpSession session2 = request.getSession();
		String table = (String) session2.getAttribute("table");
		log.info("table = ... " + table);
		service.insertBusiness(bdto, table);
		
		// 리스트 재실행
		service.selectAllBusiness(table, model);
		
		return "/Business/businessTable";
	}
	
	@RequestMapping(value = "/businessUpdateView")
	public String businessUpdateView(HttpServletRequest request, Model model) {
		log.info("사업실적 수정");
		model.addAttribute("request", request);
		HttpSession session2 = request.getSession();
		command.updateViewCommand(model);
		int bResult = 1;
		session2.setAttribute("bResult", bResult);
		
		return "/Business/businessTable";
	}
//	@RequestMapping(value = "/besinessUpdate")
//	public String besinessUpdate(HttpServletRequest request, Model model) {
//		log.info("사업실적 수정완료");
//		model.addAttribute("request", request);
//		command = new BUpdateCommand();
//		command.execute(model);
//		
//		// 리스트 재실행
//		command = new BListCommand();
//		command.execute(model);
//		
//		return "/Business/businessTable";
//	}
//	@RequestMapping(value ="/businessDelete")
//	public String businessDelete(HttpServletRequest request, Model model) {
//		log.info("사업실적 삭제완료");
//		model.addAttribute("request", request);
//		
//		// 리스트 재실행
//		command = new BListCommand();
//		command.execute(model);
//		return "/Business/businessTable";
//	}
}
