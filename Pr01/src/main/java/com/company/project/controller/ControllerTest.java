package com.company.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerTest {
	@RequestMapping(value = "modalTest")
	public String modalTest(Model model) {
		System.out.println("모달 테스트 실행");
		return "modalTest";
	}
}
