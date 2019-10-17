package com.company.project.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.project.command.HelpCommand;
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
	public void selectAllHelpWithPaging(Model model) {
		log.info("list service");
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session2 = request.getSession();
		session2.removeAttribute("help");

		int result = 0;
		if(session2.getAttribute("result") != null) {
			result = (int) session2.getAttribute("result");
		}

		Criteria cri = (Criteria) map.get("cri");
		cri.setAmount(20);
		MemberDto mdto = (MemberDto) session2.getAttribute("mdto");

		if(result == 1) {
			session2.setAttribute("helpList", mapper.selectAllHelpWithPaging(cri, mdto));
			session2.setAttribute("pageMaker", new pageDto(cri, mapper.countHelp(mdto)));
		}
	}

	@Override
	public void insertHelp(HelpDto helpDto) {
		// email command exe
		command.sendEmail(helpDto, "insert");
		
		int result = mapper.insertHelp(helpDto);
		log.info("insert result : " + result);
	}

	@Override
	public void updateHelp(HelpDto helpDto) {
		// email command exe
		command.sendEmail(helpDto, "update");
		
		int result = mapper.updateHelp(helpDto);
		log.info("update result : " + result);
	}

	@Override
	public void deleteHelp(int num) {
		// email command exe
		command.sendEmail(mapper.getHelp(num), "delete");
		
		mapper.deleteHelp(num);
	}

	@Override
	public void getHelp(int num, Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session2 = request.getSession();

		session2.setAttribute("help", mapper.getHelp(num));


	}

}
