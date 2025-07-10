package com.app.controller.study.request;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dto.study.Product;
import com.app.dto.study.ProductRequestForm;

@Controller
@RequestMapping("/request03")
public class Request03Controller {
	
	@GetMapping("/param1")
	public String param1(HttpServletRequest request) {
		System.out.println("/request03/param1");
		System.out.println(request.getParameter("msg"));
		System.out.println(request.getParameter("page"));
		System.out.println(request.getParameter("level"));
		
		return "req/param/param1";
	}
	
	@PostMapping("/param2")
	public String param2(HttpServletRequest request) {
		//  ..../param2?name=abc&count=123
		System.out.println("/request03/param2");
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("count"));
		
		return "req/param/param2";
	}
	
	@GetMapping("/param3")
	public String param3(HttpServletRequest request) {
		// http://localhost:8080/request03/param3?p1=10&p2=20&p3=30
		System.out.println("/request03/param3");
		System.out.println(request.getParameter("p1"));
		System.out.println(request.getParameter("p2"));
		//System.out.println(request.getParameter("p3")); 	//단일 파라미터 값
	
		// http://localhost:8080/request03/param3?p1=10&p2=20&p3=30&p3=40	
		//똑같은 파라미터로 값이 여러개가 들어온다?
		String[] p3Values = request.getParameterValues("p3");	//여러개 파라미터 값, 리턴값이 배열임
		for(String s : p3Values) {
			System.out.println(s);
		}
		
		return "req/param/param2";
	}
	
	@RequestMapping("/param4")
	public String param4(@RequestParam String p1, @RequestParam String p2) {
		
		// http://localhost:8080/request03/param4?p1=10&p2=20
		System.out.println("/request03/param4");
		System.out.println(p1);
		System.out.println(p2);
		
		return "req/param/param2";
	}
	
	@RequestMapping("/param5")
	public String param5(@RequestParam String p1, @RequestParam(required = false) String p2) {
															    //필수 아님
		// http://localhost:8080/request03/param5?p1=10&p2=20
		System.out.println("/request03/param5");
		System.out.println(p1);
		System.out.println(p2);
		
		return "req/param/param2";
	}
	
	@RequestMapping("/param6")		//p1에 들어오는 값을 param1Value에 넣겠다
	public String param6(@RequestParam(value="p1") String param1Value, 
						 @RequestParam(required = false, defaultValue="p2Defalut") String p2) {
														//값이 없거나, 제대로 안들어왔을 경우 기본값
		// http://localhost:8080/request03/param6?p1=10&p2=20
		System.out.println("/request03/param6");
		System.out.println(param1Value);
		System.out.println(p2);
		
		return "req/param/param2";
	}
	
	@RequestMapping("/param7")
	public String param7(@RequestParam Map<String, String> paramMap) {
						//paramMap 안에 요청들어온 파라미터 값들이 Key:Value 형태로 저장되어 전달됨
		System.out.println("/request03/param7");
		System.out.println(paramMap.get("p1"));
		System.out.println(paramMap.get("p2"));
		System.out.println(paramMap.get("count"));
		
		// http://localhost:8080/request03/param7?p1=10&p2=20&count=99
		
		return "req/param/param2";
	}
	
	@GetMapping("/param8")	// GET 조회/읽기, 초기 화면연결 역할
	public String param8() {
		System.out.println("/request03/param8 GET 요청");
		return "req/param/param8";
	}
	
	@PostMapping("/param8")	// POST 쓰기/데이터 전달, 실제 데이터를 전달받아서 로직처리 담당
	//public String param8Action(@ModelAttribute Product product) {	// Action 이나 Process를 붙여줌
	public String param8Action(@ModelAttribute ProductRequestForm productRequestForm) {
		System.out.println("/request03/param8 POST 요청");
		
		//System.out.println(product);
		System.out.println(productRequestForm);
		
		//productRequestForm -> product
		//					 -> otherDTO
		
		return "req/param/param8after";
	}

	//http://localhost:8080/request03/param9/10239 --- 10239 : itemId 부분
	@RequestMapping("/param9/{itemId}")
	public String param9(@PathVariable String itemId) {
		System.out.println("/request03/param9 요청");
		
		System.out.println(itemId);
		
		return "req/param/param2";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
