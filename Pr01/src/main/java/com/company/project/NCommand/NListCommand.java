package com.company.project.NCommand;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.company.project.dao.NewsDao;
import com.company.project.dto.NewsDto;

public class NListCommand implements NCommand{

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session2 = request.getSession();
		try {
			request.setCharacterEncoding("utf-8");
		}catch (Exception e) {
			e.printStackTrace();
		}
		NewsDao ndao = new NewsDao();
		List<NewsDto> newsList = ndao.selectAllNews();
		session2.setAttribute("newsList", newsList);
	}

}
