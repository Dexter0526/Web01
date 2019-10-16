package com.company.project.command;

import org.apache.commons.mail.SimpleEmail;

import com.company.project.dto.HelpDto;

import lombok.extern.log4j.Log4j;

@Log4j
public class HelpCommand {
	public void sendEmail(HelpDto helpDto, String action) {
		log.info("이메일 전송 실행");
		SimpleEmail email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		
		email.setAuthentication("dexterpark1992@gmail.com", "jvvuyajvtgiuwvgw");
		
		email.setSSLOnConnect(true);
		email.setStartTLSEnabled(true);
		
		String result = "fail";
		
		try {
			email.setFrom("dexterpark1992@gmail.com", "덱스터 건설", "utf-8");
			
			// ex) 기술진 email
			email.addTo("dexterpark1992@gmail.com", "덱스터 건설","utf-8");
			
			email.setSubject(helpDto.getTitle() + "  " + action);
			email.setMsg("등록 번호 : " + helpDto.getNum() + 
					"\n" + helpDto.getContent() + 
					"\\n email : " + helpDto.getEmail());
			
			result = email.send();
			log.info("메일 전송 결과 : " + result);
		}catch (Exception e) {
			e.printStackTrace();
		}
		log.info("이메일 전송 종료");
	}
}
