package com.company.project.service;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.Model;

import com.company.project.MCommand.MLogingCommand;
import com.company.project.dto.MemberDto;
import com.company.project.mapper.MemberMapper;
import com.company.project.persistence.MemberTest;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MemberServiceTest {
	
	@Setter(onMethod_ = @Autowired)
	private MemberService memberService;
	
	@Setter(onMethod_ = @Autowired)
	private MemberMapper mapper;
	
//	@Test
//	public void testExist() {
//		log.info(memberService);
//		assertNotNull(memberService);
//	}
//	@Test
//	public void userCheckTest() {
//		String email = "test";
//		String pwd = "test";
//		int result = memberService.userCheck(email, pwd);
//		log.info("결과 값 : .... "+result);
//		MemberDto mdto = memberService.getMember(email);
//		log.info("admin : .... " + mdto.getAdmin());
//	}
	
//	@Test
//	public void logingTest(HttpServletRequest request, Model model) {
//		model.addAttribute("request", request);
//		MLogingCommand command = new MLogingCommand();
//		command.execute(model);
//	}
	
//	public MemberDto getMember(String email);
//	
	@Test
	public void selectAllMemberTest(){
		memberService.selectAllMember().forEach(member -> log.info(member));
	}
//	
//	public boolean confirmEmail(String email);
//	
//	public void insertMember(MemberDto mdto);
//	
//	public int updateMember(MemberDto mdto);
//	
//	public int memberDelete(String email);
	
//	@Test
//	public void memberCount() {
//		mapper.memberCount().forEach(count -> log.info(count));
//	}
}
