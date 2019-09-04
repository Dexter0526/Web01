package com.company.project.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.company.project.mapper.PatentMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@Transactional
public class PatentServiceImpl implements PatentService{

	@Setter(onMethod_ = @Autowired)
	private PatentMapper mapper;
	
	@Override
	public void selectAllPatent(Model model){
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session2 = request.getSession();
		session2.setAttribute("patentList", mapper.selectAllPatent());
	}
	
	@Override
	public void updateViewPatent(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		HttpSession session2 = request.getSession();
		String patentNum = request.getParameter("patentNum");
		
		session2.setAttribute("patent", mapper.getPatent(patentNum));
	}
}
