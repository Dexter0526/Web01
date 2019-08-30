package com.company.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.company.project.dto.MemberDto;
import com.company.project.mapper.MemberMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@Transactional
public class MemberServiceImpl implements MemberService{

	@Setter(onMethod_ = @Autowired)
	private MemberMapper memberMapper;
	
//	@Setter(onMethod_ = @Autowired)
//	private MemberService service;
//
//	public void loging(Model model) {
//		Map<String, Object> map = model.asMap();
//		HttpServletRequest request = (HttpServletRequest) map.get("request");
//		String email = request.getParameter("email");
//		String pwd = request.getParameter("pwd");
//		
//		log.info("email : ... " + email);
//		log.info("pwd : ... " + pwd);
//		MemberServiceImpl service = new MemberServiceImpl();
//		int result = service.userCheck(email, pwd);
//		
//		if(result == 1) {
//			// service
//			MemberDto mdto = memberMapper.getMember(email);
//			int admin = mdto.getAdmin();
//			model.addAttribute("admin", admin);
//			model.addAttribute("message", "회원님 안녕하세요.");
//		}else if(result == 0) {
//			model.addAttribute("message", "비밀번호가 맞지 않습니다.");
//		}else if(result == -1) {
//			model.addAttribute("message", "회원이 존재하지 않습니다.");
//		}
//		model.addAttribute("result", result);
//	}
	
	@Override
	public int userCheck(String email, String pwd) {
		int result = -1;
		MemberDto memberDto = memberMapper.getMember(email);
		if(memberDto != null) {
			if(memberDto.getPwd() != null &&
					memberDto.getPwd().equals(pwd)) {
				result = 1;
			}else result = 0;
		}else {
			result = -1;
		}
		log.info("result : .... " + result);
		return result;
	}
	
	@Override
	public MemberDto getMember(String email) {
		log.info("get member");
		return memberMapper.getMember(email);
	}

	@Override
	public List<MemberDto> selectAllMember() {
		log.info("get member list....");
		
		return memberMapper.selectAllMember();
	}

	@Override
	public boolean confirmEmail(String email) {
		boolean result = false;
		MemberDto memberDto = memberMapper.getMember(email);
		if(memberDto != null) {
			result = true;
		}
		return result;
	}

	@Override
	public void insertMember(MemberDto mdto) {
		memberMapper.insertMember(mdto);
	}

	@Override
	public int updateMember(MemberDto mdto) {
		int result = 0;
		result = memberMapper.updateMember(mdto);
		log.info("member delete result : ...." + result);
		return result;
	}

	@Override
	public int memberDelete(String email) {
		int result = 0;
		result = memberMapper.memberDelete(email);
		log.info("member delete result : ...."+ result);
		return result;
	}


}
