package com.company.project.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.project.command.HelpCommand;
import com.company.project.dto.ConsultingDto;
import com.company.project.dto.Criteria;
import com.company.project.dto.HelpDto;
import com.company.project.dto.MemberDto;
import com.company.project.dto.pageDto;
import com.company.project.mapper.HelpMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@Transactional
public class HelpServiceImpl implements HelpService{

	@Setter(onMethod_ = @Autowired)
	private HelpMapper mapper;

	@Autowired
	private HelpCommand command;


	@Override
	public List<HelpDto> selectAllHelpWithPaging(Criteria cri, MemberDto mdto, int result) {
		log.info("list service");
		cri.setAmount(20);
		if(result == 1) {
			return mapper.selectAllHelpWithPaging(cri, mdto);
		}else {
			return null;
		}
		
	}
	
	@Override
	public pageDto pageMaker(Criteria cri, MemberDto mdto) {
		cri.setAmount(20);
		
		return new pageDto(cri, mapper.countHelp(mdto));
	}

	@Override
	public void insertHelp(HelpDto helpDto) {
		// email command exe
		command.helpSendEmail(helpDto, "insert");
		
		int result = mapper.insertHelp(helpDto);
		log.info("insert result : " + result);
	}

	@Override
	public void updateHelp(HelpDto helpDto) {
		// email command exe
		command.helpSendEmail(helpDto, "update");
		
		int result = mapper.updateHelp(helpDto);
		log.info("update result : " + result);
	}

	@Override
	public void deleteHelp(int num) {
		// email command exe
		command.helpSendEmail(mapper.getHelp(num), "delete");
		
		mapper.deleteHelp(num);
	}

	@Override
	public HelpDto getHelp(int num) {
		log.info("게시글 num : ... " + num);
		
		return mapper.getHelp(num);
	}

	
	@Override
	public ConsultingDto getConsulting(int num) {
		// TODO Auto-generated method stub
//		Map<String, Object> map = model.asMap();
//		HttpServletRequest request = (HttpServletRequest) map.get("request");
//		HttpSession session2 = request.getSession();
		
		return mapper.getConsulting(num);
	}

	@Override
	public void insertConsulting(ConsultingDto consulting) {
		// email command exe
		command.consultingSendEmail(consulting);
		
		int result = mapper.consultingInsert(consulting);
		if(result == 1) {
			mapper.helpDone(consulting, 1);
		}
		log.info("insert result : " + result);
		
	}



}
