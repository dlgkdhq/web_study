package com.app.controller.study.practice.practice11;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/practice11")
public class Practice11Controller {

	@GetMapping("/first")
	public String first(HttpServletRequest request, HttpSession session) {
		
		if(session.getAttribute("accessUrl") == null) { //없다, firsthide3를 들리지 않았음
			request.setAttribute("accessUrl", "/first");
		} else {	//세션에 "accessUrl"이 들어왔다 -> firsthide3를 들렀다가 건너옴
			//request.setAttribute("accessUrl", "/firsthide3");
			request.setAttribute("accessUrl", session.getAttribute("accessUrl"));
			//									/firsthide3
			//									/firsthide4
			
			//session.removeAttribute("accessUrl");	//특정 키값으로 삭제
			session.invalidate(); //세션 클리어
		}

		return "practice/practice11/targetPage";
	}
	
	@GetMapping("/firsthide1")
	public String firsthide1(HttpServletRequest request) {
		
		request.setAttribute("accessUrl", "/firsthide1");
		
		return "practice/practice11/targetPage";
	}
	
	@GetMapping("/firsthide2")
	public String firsthide2(HttpServletRequest request) {
		
		return "redirect:/practice11/first";
	}
	
	@GetMapping("/firsthide3")
	public String firsthide3(Model model, HttpSession session) {
		
		//model.setAttribute("accessUrl", "/firsthide3");
		
		//firsthide3에 접근했었다 라는 의미를 전달 -> session 영역에 저장
		session.setAttribute("accessUrl", "/firsthide3");
		
		return "redirect:/practice11/first";
	}
}
