package com.company.project.service;

import java.util.List;

import org.springframework.ui.Model;

import com.company.project.dto.Criteria;
import com.company.project.dto.NewsDto;

public interface NewsService {
	
//	public void selectAllNews(Model model);
	
	public NewsDto getNews(int admin, int num);
	
	public List<NewsDto> selectAllNewsWithPaging(Criteria cri);
	
	public int count();
}
