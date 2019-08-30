package com.company.project.mapper;

import java.util.List;

import com.company.project.dto.BusinessDto;

public interface BusinessMapper {
	public List<BusinessDto> selectAllBusiness(String table);
	
	public void insertBusiness(BusinessDto bdto, String table);
	
	public BusinessDto getBusiness(String num, String table);
	
	public void updateBusiness(BusinessDto bdto, String table);
	
	public void deleteBusiness(int num, String table);
	
}
