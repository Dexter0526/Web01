package com.company.project.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.company.project.dto.Criteria;
import com.company.project.dto.MemberDto;
import com.company.project.dto.pageDto;
import com.company.project.service.MemberService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Component
@Transactional
public class MemberCommandImpl implements MemberCommand{
	
	@Setter(onMethod_ = @Autowired)
	private MemberService service;
	
	@Override
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
	
	@Override
	public void logoutCommand(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		HttpSession session2 = request.getSession();
		session2.invalidate();
	}

	// 멤버 전부 출력
	@Override
	public void selectAllMemberWithPaging(Model model) {
//		Map<String, Object> map = model.asMap();
//		HttpServletRequest request = (HttpServletRequest) map.get("request");
//		HttpSession session2 = request.getSession();
//		
//		Criteria cri = (Criteria) map.get("cri");
//		cri.setAmount(20);
//		session2.setAttribute("memberList", service.selectAllMemberWithPaging(cri));
//		session2.setAttribute("pageMaker", new pageDto(cri, service.count(admin)));
	}

	// 동적쿼리 사용, 멤버 전체 or 일부 출력
	@Override
	public void selectSearchAllMemberWithPaging(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session2 = request.getSession();
		
		String position = request.getParameter("position");
		int admin = 10;
		if(position != null) {
			if(position.equals("manager")) {
				admin = 0;
			}else if(position.equals("employee")) {
				admin = 1;
			}else if(position.equals("user")) {
				admin = 2;
			}
		}
		log.info("admin : ... " + admin);
		log.info("position : ... " + position);
		model.addAttribute("position", position);
		Criteria cri = (Criteria) map.get("cri");
		cri.setAmount(20);
		session2.setAttribute("memberList", service.selectSerchAllMemberWithPaging(cri, admin));
		session2.setAttribute("pageMaker", new pageDto(cri, service.count(admin)));
	}
	
	
	
//	@Override
//	public void insertCommand(Model model) {
//		Map<String, Object> map = model.asMap();
//		HttpServletRequest request = (HttpServletRequest) map.get("request");
//		HttpSession session2 = request.getSession();
//		try {
//			request.setCharacterEncoding("UTF-8");
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//		
//		String name = request.getParameter("name");
//		String email = request.getParameter("email");
//		String pwd = request.getParameter("pwd");
//		String phone = request.getParameter("phone");
//		int admin = Integer.parseInt(request.getParameter("admin"));
//		
//		MemberDto mdto = new MemberDto();
//		mdto.setName(name);
//		mdto.setEmail(email);
//		mdto.setPwd(pwd);
//		mdto.setPhone(phone);
//		mdto.setAdmin(admin);
//		
//		service.insertMember(mdto);
//		
//		session2.setAttribute("userEmail", mdto.getEmail());
//	}

}
