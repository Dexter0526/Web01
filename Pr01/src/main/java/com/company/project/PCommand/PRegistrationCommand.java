package com.company.project.PCommand;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.company.project.dao.PatentDao;
import com.company.project.dto.PatentDto;

public class PRegistrationCommand implements Pcommand{

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		try {
			request.setCharacterEncoding("UTF-8");
		}catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String patentNum = request.getParameter("patentNum");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		PatentDto pdto = new PatentDto();
		PatentDao pdao = new PatentDao();
		pdto.setPatentNum(patentNum);
		pdto.setTitle(title);
		pdto.setContent(content);
		
		pdao.insertPatent(pdto);
	}
}
