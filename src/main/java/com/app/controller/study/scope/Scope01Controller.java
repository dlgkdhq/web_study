package com.app.controller.study.scope;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Scope01Controller {

	// scope 영역
	// request / session / application
	
	@GetMapping("/scope1")
	public String scope1(Model model) {
		
		model.addAttribute("requestMsg", "이것은 model에 추가한 메시지(request scope)");
		// 스코프 영역 중 request 영역
		
		return "scope/scope1";
	}
	
	@GetMapping("/scope2")
	public String scope2(HttpServletRequest request) {
		
		// request scope 요청할때마다! 일회성
		request.setAttribute("requestMsg", "request scope Msg");
		
		// session scope 브라우저에 대한 세션
		HttpSession session = request.getSession();
		session.setAttribute("sessionMsg", "session scope Msg");
		
		//application scope 모든 브라우저에 대해서..
		ServletContext app = request.getServletContext();
		app.setAttribute("applicationMsg", "application scope Msg");
		
		//scope2를 한번이라도 부르면 위 3개가 세팅이 됨!
		
		return "scope/scope2";
	}
	
	@GetMapping("/scope3")
	public String scope3() {
		return "scope/scope3";
		
		// 아무것도 안떠있다가, 2번을 한번 부르고 다시 들어가면 session이 세팅되어 있음
		// 다시 2번을 불렀다가 3번으로 가면 application이 세팅되어있음
		// 개발자도구 - application - cookies-> 세션 아이디 하나에 저장이 된 상태라서..!
		// 선택하고 삭제 - 새로고침 하면 초기화 됨! 다시 서버 실행하면 새로운 아이디가 생김
	}
	
	@GetMapping("/scope4")
	public String scope4(HttpSession session) {
		
		session.setAttribute("newKey", "session newKey : value");
		
		session.removeAttribute("sessionMsg"); // session scope에서 특정 키값 삭제
		
		session.invalidate();	//session scope에 저장된 모든 속성(키) 삭제 (세션 초기화)
		
		return "scope/scope3";
		
	}
}
