package com.company.project.MCommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.company.project.dao.MemberDao;
import com.company.project.dto.MemberDto;

public class MLogingCommand implements Mcommand{

	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		System.out.println("execute 실행");

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session2 = request.getSession();
		
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		
		MemberDao mdao = new MemberDao();
		int result = mdao.userCheck(email, pwd);
		System.out.println("result = " + result);
		if(result == 1) {
			MemberDto mdto = mdao.getMember(email);
			mdto.setEmail(email);
			
			session2.setAttribute("loginUser", mdto);
			session2.setAttribute("message", "회원님 안녕하세요.");
		}else if(result == 0) {
			session2.setAttribute("message", "비밀번호가 맞지 않습니다.");
		}else if(result == -1) {
			session2.setAttribute("message", "회원이 존재하지 않습니다.");
		}
	}
}

