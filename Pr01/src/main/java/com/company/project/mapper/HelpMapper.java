package com.company.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.company.project.dto.Criteria;
import com.company.project.dto.HelpDto;
import com.company.project.dto.MemberDto;

public interface HelpMapper {
	public HelpDto getHelp(int num);
	
	public List<HelpDto> selectAllHelpWithPaging(@Param("cri") Criteria cri, @Param("mdto") MemberDto mdto);
	
	public int countHelp(@Param("mdto") MemberDto mdto);
	
	public int insertHelp(@Param("helpDto") HelpDto helpDto);
	
	public int updateHelp(@Param("helpDto") HelpDto helpDto);
	
	public int deleteHelp(int num);
}
