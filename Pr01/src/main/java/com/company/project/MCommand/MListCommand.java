package com.company.project.MCommand;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.company.project.dao.MemberDao;
import com.company.project.dto.MemberDto;

public class MListCommand implements Mcommand{

	@Override
	public void execute(Model model) {
		System.out.println("MListCommand execute 실행");
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session2 = request.getSession();
		
		MemberDao mdao = new MemberDao();
		List<MemberDto> memberList = mdao.selectAllMember();
		session2.setAttribute("memberList", memberList);
	}
}
