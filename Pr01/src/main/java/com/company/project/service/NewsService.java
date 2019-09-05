package com.company.project.service;

import org.springframework.ui.Model;

public interface NewsService {
	
	public void selectAllNews(Model model);
	
	public void getNews(Model model);

}
