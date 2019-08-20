package com.company.project.BCommand;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.company.project.dao.BusinessDao;
import com.company.project.dto.BusinessDto;

public class BUpdateViewCommand implements BCommand{

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
		BusinessDao bdao = new BusinessDao();
		String num = request.getParameter("num");
		String table = (String) session2.getAttribute("table");
		BusinessDto bdto = bdao.getBusiness(num, table);
		session2.setAttribute("business", bdto);
		
	}

}
