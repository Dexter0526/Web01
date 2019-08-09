package com.company.project.MCommand;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.company.project.dao.MemberDao;
import com.company.project.dto.MemberDto;

public class MUpdateCommand implements Mcommand{

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
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		String phone = request.getParameter("phone");
		int admin = Integer.parseInt(request.getParameter("admin"));
		
		MemberDto mdto = new MemberDto();
		mdto.setName(name);
		mdto.setEmail(email);
		mdto.setPwd(pwd);
		mdto.setPhone(phone);
		mdto.setAdmin(admin);
		
		MemberDao mdao = new MemberDao();
		mdao.updateMember(mdto);
	}

}
