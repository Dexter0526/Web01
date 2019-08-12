package com.company.project.PCommand;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.company.project.dao.PatentDao;
import com.company.project.dto.PatentDto;

public class PListCommand implements Pcommand{

	@Override
	public void execute(Model model) {
		System.out.println("patentcommand");
		Map<String, Object> map  = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session2 = request.getSession();
		
		PatentDao pdao = new PatentDao();
		List<PatentDto> patentList = pdao.selectAllPatent();
		session2.setAttribute("patentList", patentList);
	}
	
}
