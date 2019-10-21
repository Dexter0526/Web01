package com.company.project.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.company.project.dto.PatentDto;
import com.company.project.mapper.PatentMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@Transactional
public class PatentServiceImpl implements PatentService{

	@Setter(onMethod_ = @Autowired)
	private PatentMapper mapper;

	@Override
	public List<PatentDto> selectAllPatent() {
		// TODO Auto-generated method stub
		return mapper.selectAllPatent();
	}

	@Override
	public PatentDto updateViewPatent(String patentNum) {
		// TODO Auto-generated method stub
		return mapper.getPatent(patentNum);
	}

	@Override
	public int insertPatent(PatentDto pdto) {
		// TODO Auto-generated method stub
		return mapper.insertPatent(pdto);
	}

	@Override
	public int updatePatent(PatentDto pdto) {
		// TODO Auto-generated method stub
		return mapper.updatePatent(pdto);
	}

	@Override
	public int deletePatent(String patentNum) {
		// TODO Auto-generated method stub
		return mapper.deletePatent(patentNum);
	}
	
	
}
