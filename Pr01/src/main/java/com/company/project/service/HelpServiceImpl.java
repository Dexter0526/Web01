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
import com.company.project.mapper.HelpMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@Transactional
public class HelpServiceImpl implements HelpService{

	@Setter(onMethod_ = @Autowired)
	private HelpMapper mapper;
	private HelpCommand command;


	@Override
	public void selectAllHelpWithPaging(Model model) {
		log.info("list service");
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		HttpSession session2 = request.getSession();

		if(session2.getAttribute("result") != null) {
			if((int) session2.getAttribute("result") != 1) {
				session2.invalidate();
			}else {
				session2.setAttribute("helpList", 
						mapper.selectAllHelpWithPaging((Criteria) map.get("cri"), 
								(MemberDto) session2.getAttribute("mdto")));
				session2.setAttribute("pageMaker", mapper.countHelp((MemberDto) session2.getAttribute("mdto")));
			}
		}
	}

	@Override
	public void insertHelp(HelpDto helpDto) {
		int result = mapper.insertHelp(helpDto);

		log.info("insert result : " + result);

		// email command exe
		command.sendEmail(helpDto, "insert");
	}

	@Override
	public void updateHelp(HelpDto helpDto) {
		int result = mapper.updateHelp(helpDto);

		log.info("update result : " + result);

		// email command exe
		command.sendEmail(helpDto, "update");
	}

	@Override
	public void deleteHelp(int num) {
		int result = mapper.deleteHelp(num);

		log.info("delete result : " + result);

		// email command exe
		command.sendEmail(mapper.getHelp(num), "delete");
	}

}
