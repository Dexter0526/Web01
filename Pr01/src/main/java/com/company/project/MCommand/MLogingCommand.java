package com.company.project.MCommand;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.company.project.dto.MemberDto;
import com.company.project.service.MemberService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;


@Log4j
@Component
@Transactional
public class MLogingCommand{
	
	@Setter(onMethod_ = @Autowired)
	private MemberService service;
	
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		log.info("email : ... " + email);
		log.info("pwd : ... " + pwd);
		// service
		log.info("service.userCheck(email, pwd) ... " + service.userCheck(email, pwd));
		int result = service.userCheck(email, pwd);

		if(result == 1) {
			// service
			MemberDto mdto = service.getMember(email);
			int admin = mdto.getAdmin();
			model.addAttribute("admin", admin);
			model.addAttribute("message", "회원님 안녕하세요.");
		}else if(result == 0) {
			model.addAttribute("message", "비밀번호가 맞지 않습니다.");
		}else if(result == -1) {
			model.addAttribute("message", "회원이 존재하지 않습니다.");
		}
		model.addAttribute("result", result);
	}
}

