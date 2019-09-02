package com.company.project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.company.project.dto.BusinessDto;

public interface BusinessMapper {
	public List<BusinessDto> selectAllBusiness(String table);
	
	public void insertBusiness(@Param("bdto") BusinessDto bdto, @Param("table") String table);
	
	public BusinessDto getBusiness(String num, String table);
	
	public void updateBusiness(BusinessDto bdto, String table);
	
	public void deleteBusiness(int num, String table);
	
}
