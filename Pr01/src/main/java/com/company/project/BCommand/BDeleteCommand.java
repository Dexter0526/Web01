package com.company.project.BCommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.company.project.dao.BusinessDao;

public class BDeleteCommand implements BCommand{

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session2 = request.getSession();
		int num = Integer.parseInt(request.getParameter("num"));
		String table = (String) session2.getAttribute("table");
		BusinessDao bdao = new BusinessDao();
		bdao.deleteBusiness(num, table);
	}

}
