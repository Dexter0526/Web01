package com.company.project.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.company.project.dto.BusinessDto;
import com.company.project.mapper.BusinessMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@Transactional
public class BusinessServiceImpl implements BusinessService{

	@Setter(onMethod_ = @Autowired)
	private BusinessMapper mapper;
	
	@Override
	public void selectAllBusiness(String table, Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session2 = request.getSession();
		session2.setAttribute("table", table);
		session2.setAttribute("businessList", mapper.selectAllBusiness(table));
	}

	@Override
	public void insertBusiness(BusinessDto bdto, String table) {
		mapper.insertBusiness(bdto, table);
	}

	@Override
	public BusinessDto getBusiness(int num, String table) {
		return mapper.getBusiness(num, table);
	}

	@Override
	public void updateBusiness(BusinessDto bdto, String table) {
		mapper.updateBusiness(bdto, table);
	}

	@Override
	public void deleteBusiness(int num, String table) {
		mapper.deleteBusiness(num, table);
	}

}
