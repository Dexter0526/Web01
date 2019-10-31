package com.company.project.command;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.company.project.dto.ConsultingDto;
import com.company.project.dto.HelpDto;

import lombok.extern.log4j.Log4j;

@Log4j
@Component
@Transactional
public class HelpCommandImpl implements HelpCommand{

	@Autowired
	private JavaMailSender mailSender;
	
	// 사용자 게시글 작성시 해당 기술 부서에서 메일 전송
	@Override
	public void helpSendEmail(HelpDto helpDto, String action) {
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

	// 해당 부서 게시글 답변 등록시 게시글 작성자에게 답변 완료 메일 전송
	@Override
	public void consultingSendEmail(ConsultingDto consulting) {
		log.info("sendEmail 실행");
		String setfrom = "@gmail.com";	// 관리자
		String tomail = consulting.getSendEmail();	// 받는 사람(사용자)
		String title = consulting.getTitle();
		String content = consulting.getContent();

		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "utf-8");
			
			messageHelper.setFrom(setfrom);	// 보내는 사람
			messageHelper.setTo(tomail);
			messageHelper.setSubject("덱스터 건설 상담 답변");
			messageHelper.setText("답변 : " + "\n\n"
								+ "제목 : \n" + title + "\n\n"
								+ "내용 : \n" + content);
			
			mailSender.send(message);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
