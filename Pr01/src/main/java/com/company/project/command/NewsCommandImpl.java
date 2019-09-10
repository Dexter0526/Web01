package com.company.project.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.company.project.dto.Criteria;
import com.company.project.dto.pageDto;
import com.company.project.service.NewsService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Component
@Transactional
public class NewsCommandImpl implements NewsCommand{

	@Setter(onMethod_ = @Autowired)
	private NewsService service;
	
	@Override
	public void selectAllNewsWithPaging(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session2 = request.getSession();
		
		Criteria cri = (Criteria) map.get("cri");
		
		session2.setAttribute("newsList", service.selectAllNewsWithPaging(cri));
		session2.setAttribute("pageMaker", new pageDto(cri, service.count()));
		
	}

}
