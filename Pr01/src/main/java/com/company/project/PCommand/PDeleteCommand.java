package com.company.project.PCommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.company.project.dao.PatentDao;

public class PDeleteCommand implements Pcommand{

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String patentNum = request.getParameter("patentNum");
		PatentDao pdao = new PatentDao();
		pdao.deletePatent(patentNum);
	}

}
