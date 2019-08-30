package com.company.project.MCommand;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.company.project.dao.MemberDao;
import com.company.project.dto.MemberDto;

public class MUpdateViewCommand implements MCommand{

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session2 = request.getSession();
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		MemberDao mdao = new MemberDao();
		String email = request.getParameter("email");
		MemberDto mdto = mdao.getMember(email);
		session2.setAttribute("member", mdto);
	}

}
