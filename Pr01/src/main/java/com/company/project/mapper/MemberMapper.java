package com.company.project.mapper;

import java.util.List;

import com.company.project.dto.MemberDto;

public interface MemberMapper {
	public MemberDto getMember(String email);
	
	public List<MemberDto> selectAllMember();
	
	public void confirmEmail(String email);
	
	public void insertMember(MemberDto mdto);
	
	public int updateMember(MemberDto mdto);
	
	public int memberDelete(String email);
}
