package com.company.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.company.project.command.MemberCommand;
import com.company.project.dto.Criteria;
import com.company.project.dto.MemberDto;
import com.company.project.mapper.MemberMapper;
import com.company.project.service.MemberService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@AllArgsConstructor
@Controller
public class MemberController {
	
//	@Setter(onMethod_ = @Autowired)
	private MemberService service;
	
//	@Setter(onMethod_ = @Autowired)
	private MemberCommand command;
	
	private MemberMapper mapper;

	// 멤버 설정뷰(마스터 권한)
	@RequestMapping(value = "/memberView")
	public String memberView(Criteria cri, HttpServletRequest request, Model model) {
		log.info("멤버 뷰");
		log.info("cri : ... " + cri);
//		model.addAttribute("memberList", service.selectAllMember());
		
		model.addAttribute("memberCount", mapper.memberCount());
		model.addAttribute("request", request);
		model.addAttribute("cri", cri);
		
//		command.selectAllMemberWithPaging(model);
		command.selectSearchAllMemberWithPaging(model);

		return "Erp/Member/memberView";
	}
	
	@RequestMapping(value = "/positionView")
	public String positionView(Criteria cri, HttpServletRequest request, Model model) {
		log.info("직책 선택 뷰");
//		model.addAttribute("memberList", mapper.selectSerchMember(admin));
		model.addAttribute("memberCount", mapper.memberCount());
		model.addAttribute("request", request);
		model.addAttribute("cri", cri);
		command.selectSearchAllMemberWithPaging(model);
		
		return "Erp/Member/memberView";
	}
	
	// ERP뷰
	@RequestMapping(value = "/memberIndexView")
	public String member_index_view(Model model) {
		System.out.println("member index view");

		return "Erp/ErpIndexView";
	}
	
	// 로그인
	@RequestMapping(value = "/login")
	public String log_process(HttpServletRequest request, Model model) {
		model.addAttribute("request", request);
		HttpSession session2 = request.getSession();
		// 커맨드 사용(Component)
		command.logingCommand(model);
		int result = (int) session2.getAttribute("result");
		
		// service만 사용
//		String email = request.getParameter("email");
//		String pwd = request.getParameter("pwd");
//		int result = service.userCheck(email, pwd);
		
//		// service(내부 함수 다중 사용)
//		service.loging(model);
//		int result = (int) map.get("result");
		
		if(result == 1 ) {
			return "index";
		}else {
			return "Log/log";
		}
	}

	@RequestMapping(value = "/logout")
	public String logout_process(HttpServletRequest request, Model model) {
		log.info("logout");
		model.addAttribute("request", request);
		command.logoutCommand(model);
		
		return "index";
	}
	
	@RequestMapping(value = "/signup")
	public String singUp(Model model) {
		log.info("sign up view");
		
		return "Log/signUp";
	}
	
//	@RequestMapping(value = "/join")
//	public String join(HttpServletRequest request, Model model) {
//		System.out.println("회원가입");
//		model.addAttribute("request", request);
//		
//		command.insertCommand(model);
//
//		return "MemberView/memberView";
//	}
	
	
	//	dto객체 이동 테스트
	@RequestMapping(value = "/join")
	public String join(MemberDto mdto, RedirectAttributes rttr) {
		log.info("회원가입 성공");
		service.insertMember(mdto);
		rttr.addFlashAttribute("admin", mdto.getAdmin());
		
		if(mdto.getAdmin() == 2) {
			return "index";
		}else {
			return "Erp/ErpIndexView";			
		}
		
	}
	
	@RequestMapping(value = "/memberUpdateView")
	public String memberUpdateView(HttpServletRequest request, Model model) {
		log.info("회원 수정 화면");
		model.addAttribute("request", request);
		
		service.updateView(model);
		
		return "Log/memberUpdateView";
	}
	
	@RequestMapping(value = "/memberUpdate")
	public String memberUpdate(MemberDto mdto) {
		log.info("수정 완료");
		service.updateMember(mdto);
		
		return "Erp/ErpIndexView";
	}
	
	@RequestMapping(value = "/memberDelete")
	public String memberDelete(HttpServletRequest request, Model model) {
		log.info("회원 삭제");
		String email = request.getParameter("email");
		service.memberDelete(email);
		
		return "Erp/ErpIndexView";
	}
	
	
}
