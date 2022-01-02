package com.ch.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Naver_Api { // http://localhost:8080/project3/WEB-INF/views/main/naver_api.jsp
	@RequestMapping("naver_api")
	public String naver_api() {
		return "main/naver_api";
	}
}
