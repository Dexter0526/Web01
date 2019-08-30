package com.company.project.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.company.project.dto.MemberDto;
import com.company.project.service.MemberService;
import com.company.project.service.MemberServiceTest;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MemberCommandTest{
	
	@Setter(onMethod_ = @Autowired)
	private MemberService service;
	
	public void logingCommand(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session2 = request.getSession();
		
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		
		// 정상 파라미터값 확인
		log.info("email : ... " + email);
		log.info("pwd : ... " + pwd);
		
		log.info("service.userCheck(email, pwd) ... " + service.userCheck(email, pwd));
		int result = service.userCheck(email, pwd);

		if(result == 1) {
			// service
			MemberDto mdto = service.getMember(email);
			int admin = mdto.getAdmin();
			session2.setAttribute("admin", admin);
			session2.setAttribute("message", "회원님 안녕하세요.");
		}else if(result == 0) {
			session2.setAttribute("message", "비밀번호가 맞지 않습니다.");
		}else if(result == -1) {
			session2.setAttribute("message", "회원이 존재하지 않습니다.");
		}
		session2.setAttribute("result", result);
		
	}
	
	public void logoutCommand(Model model) {

		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		HttpSession session2 = request.getSession();
		session2.invalidate();
	}

}
