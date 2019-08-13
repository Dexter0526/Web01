package com.company.project.PCommand;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.company.project.dao.PatentDao;
import com.company.project.dto.PatentDto;

public class PUpdateViewCommand implements Pcommand{

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		HttpSession session2 = request.getSession();
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		PatentDao pdao = new PatentDao();
		String patentNum = request.getParameter("patentNum");
		PatentDto pdto = pdao.getPatent(patentNum);
		session2.setAttribute("patent", pdto);
	}

}
