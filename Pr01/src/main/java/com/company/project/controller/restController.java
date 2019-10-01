package com.company.project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.project.mapper.MemberMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@AllArgsConstructor
@RestController
public class restController {
	
	private MemberMapper mapper;
	

	// email check
	@GetMapping(value="/emailCheck")
	public int idcheck(@RequestParam("email") String email) {
		log.info("이메일 체크");
		int result = mapper.confirmEmail(email);
		log.info("result : ... " + result);
		return result;
	}
	
}
