package com.company.project.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.company.project.service.BusinessService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Component
@Transactional
public class BusinessCommandImpl implements BusinessCommand{
	
	@Setter(onMethod_ = @Autowired)
	private BusinessService service;
	
	@Override
	public void selectAllBusiness(Model model) {
		log.info("사업분야 테이블 실행(command)");
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session2 = request.getSession();
		
	}

}
