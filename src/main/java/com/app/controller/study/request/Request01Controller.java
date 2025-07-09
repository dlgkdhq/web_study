package com.app.controller.study.request;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/* 컴포넌트 등록이 되려면
 	servelt-context.xml에 설정되어 있는
 	context:component-scan base-package="com.app.controller"
 	
 	base-package 경로 하위에 존재해야 함.
 */

//Controller 컴포넌트로 인식해서 스프링에 등록
@Controller	//어노테이션
public class Request01Controller {
	
	//요청 들어오는 주소별로 맵핑을 시켜주는 역할
	@RequestMapping("/url1")	//"/url1" 이 경로로 요청이 들어왔을 때 담당 설정
	public String url1() {	//이 경로로 들어왔을 때 실행되는 메소드
		
		return "url1";	
		// 리턴하는 문자열의 이름을 가지고 있는 view 파일 명시해서 view 파일로 연결시켜줌
		// ViewResolver 설정으로 인해서 앞에 /WEB-INF/views/ 뒤에 .jsp가 붙는다
		// /WEB-INF/views/  "리턴한 뷰 이름의 문자열"  .jsp 	
	}
	
	@RequestMapping("/url2")
	public String url2() {
		return "home";
	}
	
	@RequestMapping("/url3")
	public String url3() {
		return "url3";
	}
	
	@RequestMapping("/url4")									//GET POST 구분하지 않고 둘다 수신
	public String url4() {
		return "req/url4";
		// /WEB-INF/views/  "url4"  .jsp  -> 인식 못함.
		// 실제 url4 경로 -> /WEB-INF/views/req/url4.jsp
		// /WEB-INF/views/  "req/url4"  .jsp	
		// 폴더 경로에 따라서 return 명을 써줘야함.
	}
	
	//HTTP 통신 Method = GET, POST, DELETE, PUT, PATCH
	// GET (조회 Read), POST (저장 Insert/Write)
	@RequestMapping(value="/url5", method = RequestMethod.GET) 	//GET 방식으로 요청했을 때만 수신
	public String url5() {
		return "req/url4";
	}
	
	// 인터넷 브라우저 주소창에 주소를 입력하고 이동하는 방식 -> GET 방식의 요청
	// post 방식을 쉽게 요청하도록 하는게 Postman
	@RequestMapping(value="/url6", method = RequestMethod.POST)	//POST 방식으로 요청했을 때만 수신
	public String url6() {
		return "req/url4";
	}
	
	@GetMapping("/url7")
	public String url7() {
		return "req/url4";
	}
	
	@PostMapping("/url8")
	public String url8() {
		return "req/url4";
	}
	
	@GetMapping("/request01/url9")
	public String url9() {
		return "req/url4";
	}
}
