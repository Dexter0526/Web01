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
	public NewsDto getNews(int num) {
		mapper.updateCount(num);
//		session2.setAttribute("news", mapper.getNews(num));
		
		NewsDto ndto = mapper.getNews(num);
//		ndto.setContent(ndto.getContent().replace("\r\n", "<br>"));
		
		return ndto;
	}

	@Override
	public List<NewsDto> selectAllNewsWithPaging(Criteria cri) {
		
		return mapper.selectAllNewsWithPaging(cri);
	}

	@Override
	public int count() {
		int count = mapper.count();
		log.info("mapper.count() : ... " + count);
		return count;
	}
	
}
