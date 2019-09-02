package com.company.project.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.company.project.dto.BusinessDto;

public interface BusinessService {
	public void selectAllBusiness(String table, Model model);
	
	public void insertBusiness(BusinessDto bdto, String table);
	
	public BusinessDto getBusiness(String num, String table);
	
	public void updateBusiness(BusinessDto bdto, String table);
	
	public void deleteBusiness(int num, String table);

}
