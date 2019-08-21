package com.company.project.NCommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.company.project.dao.NewsDao;

public class NDeleteCommand implements NCommand{

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session2 = request.getSession();
		int num = Integer.parseInt(request.getParameter("num"));
		
		session2.removeAttribute("nresult");
		NewsDao ndao = new NewsDao();
		ndao.deleteNews(num);
	}
}
