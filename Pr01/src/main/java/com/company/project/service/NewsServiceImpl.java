package com.company.project.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.company.project.dto.Criteria;
import com.company.project.dto.NewsDto;
import com.company.project.mapper.NewsMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@Transactional
public class NewsServiceImpl implements NewsService{

	@Setter(onMethod_ = @Autowired)
	private NewsMapper mapper;
	
//	@Override
//	public void selectAllNews(Model model) {
//		Map<String, Object> map = model.asMap();
//		HttpServletRequest request = (HttpServletRequest) map.get("request");
//		HttpSession session2 = request.getSession();
//		session2.setAttribute("newsList", mapper.selectAllNews());
//	}

	@Override
	public void getNews(Model model) {
		int nresult = 0;
		int admin = 0;
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		HttpSession session2 = request.getSession();
		int num = Integer.parseInt(request.getParameter("num"));
		mapper.updateCount(num);
		session2.setAttribute("news", mapper.getNews(num));
		
		if(session2.getAttribute("admin") != null) {
			admin = (Integer) session2.getAttribute("admin");
			if(admin==0||admin==1) {
				nresult = 1;
			}
		}
		session2.setAttribute("nresult", nresult);
		log.info("nresult = " + nresult);
	}

	@Override
	public List<NewsDto> selectAllNewsWithPaging(Criteria cri) {
		
		return mapper.selectAllNewsWithPaging(cri);
	}
	
}
