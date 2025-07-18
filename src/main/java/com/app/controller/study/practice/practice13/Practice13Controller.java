package com.app.controller.study.practice.practice13;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.util.MyCookieUtil;

@Controller
@RequestMapping("/practice13")
public class Practice13Controller {

	@GetMapping("/hideAd")
	public String hideAd(HttpServletRequest request) {
		
		String check = MyCookieUtil.getCookie(request, "check");
		if(check != null) {
			request.setAttribute("check", check);
		}
		
		return "practice/practice13/hideAd";
	}
	
	@PostMapping("/hideAd")
	public String hideAdAction(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println(request.getParameter("check"));
		
		//24시간 보지 않기 체크 후 요청을 했으면 쿠키에 값 저장
		// -> 나중에 해당 화면에 접근 시, 광고 표시 여부로 활용
		
		String check = request.getParameter("check");
		
		if(check != null) {
			Cookie ck = MyCookieUtil.createCookie("check", check, 86400);
			response.addCookie(ck);
		}
		
		return "redirect:/practice13/hideAd";
	}

}
