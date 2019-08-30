package com.company.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public List<BusinessDto> selectAllBusiness(String table) {
		return mapper.selectAllBusiness(table);
	}

	@Override
	public void insertBusiness(BusinessDto bdto, String table) {
		mapper.insertBusiness(bdto, table);
	}

	@Override
	public BusinessDto getBusiness(String num, String table) {
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
