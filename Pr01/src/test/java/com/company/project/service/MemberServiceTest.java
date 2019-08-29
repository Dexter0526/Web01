package com.company.project.service;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
	
//	@Test
//	public void testExist() {
//		log.info(memberService);
//		assertNotNull(memberService);
//	}
	
//	public int userCheck(String email, String pwd);
//	
//	public MemberDto getMember(String email);
//	
	@Test
	public void selectAllMember(){
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
}
