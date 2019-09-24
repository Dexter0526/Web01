package com.company.project.service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.company.project.dao.MemberDao;
import com.company.project.dto.Criteria;
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
	private MemberMapper mapper;
	
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
		MemberDto memberDto = mapper.getMember(email);
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
		return mapper.getMember(email);
	}

	@Override
	public List<MemberDto> selectAllMember() {
		log.info("get member list....");
		
		return mapper.selectAllMember();
	}

	@Override
	public boolean confirmEmail(String email) {
		boolean result = false;
		MemberDto memberDto = mapper.getMember(email);
		if(memberDto != null) {
			result = true;
		}
		return result;
	}

	@Override
	public void insertMember(MemberDto mdto) {
		mapper.insertMember(mdto);
	}

	@Override
	public int updateMember(MemberDto mdto) {
		int result = 0;
		log.info("email = ... " + mdto.getEmail());
		result = mapper.updateMember(mdto);
		log.info("member update result : ...." + result);
		return result;
	}

	@Override
	public int memberDelete(String email) {
		int result = 0;
		result = mapper.memberDelete(email);
		log.info("member delete result : ...."+ result);
		return result;
	}

	@Override
	public void updateView(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session2 = request.getSession();
		String email = request.getParameter("email");
		log.info("email = ... " + email);
		MemberDto mdto = mapper.getMember(email);
		session2.setAttribute("member", mdto);
	}

	@Override
	public List<MemberDto> selectAllMemberWithPaging(Criteria cri) {
		return mapper.selectAllMemberWithPaging(cri);
	}

	@Override
	public int count(int admin) {
		return mapper.count(admin);
	}

	@Override
	public List<MemberDto> selectSerchAllMemberWithPaging(Criteria cri, int admin) {
		return mapper.selectSerchAllMemberWithPaging(cri, admin);
	}
}
