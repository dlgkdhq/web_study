package com.app.controller.study.cookie;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.util.MyCookieUtil;

@Controller
public class Cookie01Controller {

	@GetMapping("/saveCookie")
	public String saveCookie(HttpServletResponse response) {
		
		//서버에서 쿠키 생성 -전달-> 사용자(브라우저)
		//						쿠키가 있으면? -> 쿠키 저장
		
		Cookie ck1 = new Cookie("menu", "cutlet");
		ck1.setMaxAge(60 * 60 * 12);	//쿠키의 수명(어느정도 유효한 기간), 초단위
					//60초 * 60 = 60분
					//60분 * 12 = 12시간
		
		response.addCookie(ck1);
		
		Cookie ck2 = new Cookie("today", "WED");
		ck2.setMaxAge(30);
		
		response.addCookie(ck2);
		
		// 쿠키에서 띄어쓰기 -> URLEncode 처리해서 사용 가능 , 띄어쓰기 자리에 + 가 생김
		try {
			String value = URLEncoder.encode("plus 15", "UTF-8");
			
			//Cookie ck3 = new Cookie("temperature", "plus 15");
			Cookie ck3 = new Cookie("temperature", value);
			ck3.setMaxAge(100);
			
			response.addCookie(ck3);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		//util 사용
		Cookie ck4 = MyCookieUtil.createCookie("ck4Name", "ck4Value");
		Cookie ck5 = MyCookieUtil.createCookie("ck5Name", "ck5Value", 3600);

		return "cookie/saveCookie";
	}
	
	@GetMapping("/removeCookie")
	public String removeCookie(HttpServletResponse response) {	//쿠키 삭제
		
		Cookie ck1 = new Cookie("menu", "vvvv");
		ck1.setMaxAge(0);	// 수명 0 -> 브라우저 인식 -> 수명0 쿠키 처리
		
		response.addCookie(ck1);
		
		//util 사용
		Cookie ckk = MyCookieUtil.createCookieForRemove("abc");
		response.addCookie(ckk);
		
		return "cookie/saveCookie";
	}
	
	@GetMapping("/readCookie")
	public String readCookie(HttpServletRequest request) {	//쿠키 읽어오기
		
		Cookie[] cookies = request.getCookies();
		
		String menu = null;
		for(Cookie ck : cookies) {
			System.out.println(ck.getName() + " " + ck.getValue());
			
			if(ck.getName().equals("menu")) {
				menu = ck.getValue();
			}
			
			if(ck.getName().equals("temperature")) {
				try {
					System.out.println("decode : " + URLDecoder.decode(ck.getValue(), "UTF-8"));	//디코딩 해서 출력
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
		}
		
		//Util 사용
		menu = MyCookieUtil.getCookie(cookies, "menu");
		
		request.setAttribute("menu", menu);
		
		String temperature = MyCookieUtil.getCookie(cookies, "temperature");
		temperature = MyCookieUtil.getCookie(request, "temperature");
		
		return "cookie/readCookie";
	}
	
	@GetMapping("/readCookie2")
	public String readCookie2(@CookieValue(required=false) String menu, @CookieValue String temperature) {
							//값이 없으면 오류가 뜸 requestParam 처럼,, 
							//(required=false) 걸어주면 값이 없어도 오류 안남
		System.out.println(menu);
		System.out.println(temperature);
		
		return "cookie/readCookie";
	}
	
	
}
