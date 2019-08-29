package com.company.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.project.dto.MemberDto;
import com.company.project.mapper.MemberMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@Transactional
@AllArgsConstructor
public class MemberServiceImpl implements MemberService{

	@Setter(onMethod_ = @Autowired)
	private MemberMapper memberMapper;
	

	@Override
	public int userCheck(String email, String pwd) {
		int result = -1;
		MemberDto memberDto = memberMapper.getMember(email);
		if(memberDto.getPwd() != null &&
				memberDto.getPwd().equals("pwd")) {
			result = 1;
		}else result = 0;
		
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
