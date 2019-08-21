package com.company.project.NCommand;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.company.project.dao.NewsDao;
import com.company.project.dto.NewsDto;

public class NGetCommand implements NCommand{

	@Override
	public void execute(Model model) {
		int nresult = 0;
		int admin = 0;
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		HttpSession session2 = request.getSession();
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		NewsDao ndao = new NewsDao();
		int num = Integer.parseInt(request.getParameter("num"));
		ndao.updateCount(num);
		NewsDto ndto = ndao.getNews(num);
		session2.setAttribute("news", ndto);
		
		if(session2.getAttribute("admin") != null) {
			admin = (Integer) session2.getAttribute("admin");
			if(admin==0||admin==1) {
				nresult = 1;
			}
		}
		session2.setAttribute("nresult", nresult);
		System.out.println("nresult = " + nresult);
	}

}
