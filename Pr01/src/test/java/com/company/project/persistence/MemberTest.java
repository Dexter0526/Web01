package com.company.project.persistence;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.company.project.dto.MemberDto;
import com.company.project.mapper.MemberMapper;
import com.company.project.service.MemberServiceTest;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MemberTest {

	@Setter(onMethod_ = @Autowired)
	private MemberMapper mapper;
	
	@Test
	public void test() {
		log.info("member test : ... ");
		
		mapper.selectAllMember().forEach(member -> log.info(member));
	}
	
//	
//	@Test
//	public void insertTest() {
//		log.info("insert Test");
//		MemberDto mdto = new MemberDto();
//		mdto.setEmail("test");
//		mdto.setName("test");
//		mdto.setPhone("test");
//		mdto.setPwd("test");
//		mdto.setAdmin(2);
//		
//		mapper.insertMember(mdto);
//		log.info(mdto);
//	}
}
