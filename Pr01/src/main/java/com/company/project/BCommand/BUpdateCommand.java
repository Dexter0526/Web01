package com.company.project.BCommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.company.project.dao.BusinessDao;
import com.company.project.dto.BusinessDto;

public class BUpdateCommand implements BCommand{

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
		String field = request.getParameter("field");
		int num = Integer.parseInt(request.getParameter("num"));
		String table = (String) session2.getAttribute("table");
		
		BusinessDto bdto = new BusinessDto();
		BusinessDao bdao = new BusinessDao();
		bdto.setNum(num);
		bdto.setTitle(title);
		bdto.setContent(content);
		bdto.setField(field);
		
		bdao.updateBusiness(bdto, table);
	}

}
