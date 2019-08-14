package com.company.project.BCommand;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.company.project.dao.BusinessDao;
import com.company.project.dto.BusinessDto;

public class BListCommand implements BCommand{

	@Override
	public void execute(Model model) {
		System.out.println("BListCommand execute 실행");
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session2 = request.getSession();
		try {
			request.setCharacterEncoding("utf-8");
		}catch (Exception e) {
			e.printStackTrace();
		}
		String table = (String) session2.getAttribute("table");
		BusinessDao bdao = new BusinessDao();
		List<BusinessDto> businessList = bdao.selectAllBusiness(table);
		session2.setAttribute("businessList", businessList);
	}

}
