package com.company.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.project.dto.MemberDto;
import com.company.project.mapper.MemberMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService{

	@Setter(onMethod_ = @Autowired)
	private MemberMapper memberMapper;
	
	@Override
	public MemberDto getMember(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberDto> selectAllMember() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void confirmEmail(String email) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertMember(MemberDto mdto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int updateMember(MemberDto mdto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int memberDelete(String email) {
		// TODO Auto-generated method stub
		return 0;
	}

}
