package com.company.project.command;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.company.project.dto.HelpDto;

import lombok.extern.log4j.Log4j;

@Log4j
@Component
@Transactional
public class HelpCommandImpl implements HelpCommand{

	@Autowired
	private JavaMailSender mailSender;
	
	@Override
	public void sendEmail(HelpDto helpDto, String action) {
		log.info("sendEmail 실행");
		String setfrom = "@gmail.com";	// 관리자
		String tomail = "@gmail.com";	// 기술자(받는 사람)
		String title = helpDto.getTitle();
		String content = helpDto.getContent();
		String userEmail = helpDto.getEmail();

		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "utf-8");
			
			messageHelper.setFrom(setfrom);	// 보내는 사람
			messageHelper.setTo(tomail);
			messageHelper.setSubject("덱스터 건설 상담 내역 : " + action);
			messageHelper.setText("사용자 이메일 : " + userEmail + "\n\n"
								+ "제목 : \n" + title + "\n\n"
								+ "내용 : \n" + content);
			
			mailSender.send(message);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
