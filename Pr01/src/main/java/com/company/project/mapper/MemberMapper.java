package com.company.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.company.project.dto.Criteria;
import com.company.project.dto.MemberCountDto;
import com.company.project.dto.MemberDto;

public interface MemberMapper {
	public MemberDto getMember(String email);
	
	public List<MemberDto> selectAllMember();
	
	public List<MemberDto> selectAllMemberWithPaging(@Param("cri") Criteria cri);
	
	public void confirmEmail(String email);
	
	public void insertMember(MemberDto mdto);
	
	public int updateMember(MemberDto mdto);
	
	public int memberDelete(String email);
	
	public List<MemberCountDto> memberCount();
	
	public List<MemberDto> selectSerchMember(int admin);
	
	public List<MemberDto> selectSerchAllMemberWithPaging(@Param("cri") Criteria cri, @Param("admin") int admin);
	
	public int count(@Param("admin") int admin);
}
