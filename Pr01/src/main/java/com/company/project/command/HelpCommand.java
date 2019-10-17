package com.company.project.command;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.company.project.dto.HelpDto;

import lombok.extern.log4j.Log4j;

@Log4j
@Component
@Transactional
public class HelpCommand {
	
	@Autowired
	private JavaMailSender mailSender;
	
	public void sendEmail(HelpDto helpDto, String action) {
		
		
	}
}
