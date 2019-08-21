package com.company.project.NCommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.company.project.dao.NewsDao;
import com.company.project.dto.NewsDto;

public class NUpdateCommand implements NCommand{

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
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int num = Integer.parseInt(request.getParameter("num"));
		
		NewsDto ndto = new NewsDto();
		NewsDao ndao = new NewsDao();
		ndto.setNum(num);
		ndto.setTitle(title);
		ndto.setContent(content);
		
		ndao.updateNews(ndto);
		session2.removeAttribute("nresult");
	}

}
