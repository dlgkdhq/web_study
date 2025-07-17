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
import org.springframework.web.bind.annotation.PostMapping;

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
	
	// *** Cookie 활용 아이디 기억
	@GetMapping("/idCookie")
	public String idCookie(HttpServletRequest request) {
		
		// 쿠키에서 remember 값이 있는지 체크!
		// 있으면 아이디 기억한거를 화면에 표시
		// 없으면 그냥 패스
		
		String remember = MyCookieUtil.getCookie(request, "remember");
		if(remember != null) { //아이디 기억 O
			request.setAttribute("remember", remember);
		}
		
		return "cookie/idCookie";
	}
	
	@PostMapping("/idCookie")
	public String idCookieAction(HttpServletRequest request, HttpServletResponse response) {
		
		//로직 처리...
		System.out.println(request.getParameter("id"));
		System.out.println(request.getParameter("pw"));
		System.out.println(request.getParameter("remember"));
		
		String id = request.getParameter("id");
		String remember = request.getParameter("remember");
		
		// 실제 로그인 로직
		// 입력 유효성 검증
		// id pw <--> DB저장 데이터
		// 맞으면 로그인 성공 -> 성공 시 넘어갈 페이지로 이동
		// 틀리면 로그인 실패 -> 다시 로그인 화면
		
		// 아이디 기억 체크 여부 확인 -> 체크 O -> 쿠키에 아이디를 저장해두자
		if(remember == null) { //아이디 기억 체크 X
			//기억하지 않겠다! -> 쿠키 값 삭제
			Cookie ck = MyCookieUtil.createCookieForRemove("remember");
			response.addCookie(ck);
			
		} else { //아이디 기억 체크 O -> 쿠키에 저장
			
			boolean isRemeber = Boolean.parseBoolean(remember); //String -> boolean
			//if(remember.equals("true")) 한번 더 검증할 수 있다~
			
			//id 값 저장
			Cookie ck = MyCookieUtil.createCookie("remember", id, 3600);
			response.addCookie(ck);
		}
		
		//로그인 처리가 완료된 후에 보여줄 페이지 이동
		//return "cookie/readCookie";	//view자원의 경로. 보내도 경로가 그대로 idCookie가 됨
		return "redirect:/readCookie";	//url mapping 경로
	}
}
