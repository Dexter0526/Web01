package com.company.project.MCommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.company.project.dao.MemberDao;

public class MDeleteCommand implements Mcommand{

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String email = request.getParameter("email");
		System.out.println(email);
		MemberDao mdao = new MemberDao();
		mdao.memberDelete(email);
	}

}
