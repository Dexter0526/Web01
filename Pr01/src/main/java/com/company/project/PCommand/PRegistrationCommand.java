package com.company.project.PCommand;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

public class PRegistrationCommand implements Pcommand{

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session2 = request.getSession();
		try {
			request.setCharacterEncoding("UTF-8");
		}catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String patentNum = request.getParameter("patentNum");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		
	}
}
