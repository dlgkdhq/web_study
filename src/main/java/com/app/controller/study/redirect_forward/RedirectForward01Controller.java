package com.app.controller.study.redirect_forward;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RedirectForward01Controller {

	@GetMapping("/re/re1")
	public String re1() {
		return "re/re1";
	}
	
	@GetMapping("/re/re2")
	public String re2(HttpServletRequest request) {
		
		System.out.println("/re/re2");
		System.out.println(request.getParameter("msg"));
		
		request.setAttribute("msg", request.getParameter("msg"));
		
		return "re/re2";
	}
	
	@GetMapping("/re/re3")
	public String re3(HttpServletRequest request) {
		System.out.println("/re/re3");
		System.out.println(request.getParameter("msg"));
		
		request.setAttribute("msg", request.getParameter("msg"));
		
		return "re/re2";	//요청은 re3로 들어왔는데 화면(view)는 re2로 연결하겠다
		//페이지 내부의 redirect 처리
	}
	
	@GetMapping("/re/re4")
	public String re4(HttpServletRequest request) {
		
		//페이지 내부의 redirect 처리
		System.out.println("/re/re4");
		System.out.println(request.getParameter("msg"));
		
		return "re/re4"; //요청	/re4 -> 화면(view) re4 -> 페이지 내부에서 re2로 처리
	}
	
	@GetMapping("/re/re5")
	public String re5(HttpServletRequest request) {
		
		//서버에서 redirect 처리
		System.out.println("/re/re5");
		System.out.println(request.getParameter("msg"));
		
		return "redirect:/re/re2";	// /re/re2 경로로 redirect
		// 화면 view return 아님!!
		
		// view 이름 return 	/WEB-INF/views/		"re/re2"	.jsp
		
		// redirect 주소창에 들어갈 경로!		localhost:8080	"re/re2"	
		// 다시 주소창에 들어갈 경로를 써줌! 맵핑 경로를 써주는거~
	}
	
	@GetMapping("/re/re6")
	public String re6(HttpServletRequest request) {
		
		//서버에서 forward 처리
		System.out.println("/re/re6");
		System.out.println(request.getParameter("msg"));
		
		//forward 서버에서 바로 요청 경로를 바꿔서 수행, 그대로 전달된다.
		
		return "forward:/re/re2";
	}
	
	@GetMapping("/re/re7")
	public String re7(HttpServletRequest request, RedirectAttributes ra) {
		
		//서버에서 redirect 처리
		System.out.println("/re/re7");
		System.out.println(request.getParameter("msg"));	
		
		//request.setAttribute("msg", request.getParameter("msg")) //view 데이터/객체 전달용
		//불가능. redirect 시에 새로운 request로 요청되기 때문에 redirect하면 안넘어감!
		
		//return "redirect:/re/re2?msg=" + request.getParameter("msg"); 
											//넘길 때 주소창에 메시지를 유지할 수 있음
		//redirect 경로에 직접 parameter 들어간 주소 형식으로 작성 /re/re2
		
		//RedirectAttributes 활용
		//ra.addAttribute("msg", request.getParameter("msg"));	
			// redirect 요청주소 경로 뒤에 파라미터 추가해서 연결
			// -> 연결된 서버 측 메소드에서도 경로에 있는 Parameter 확인 가능
		ra.addFlashAttribute("msg", request.getParameter("msg"));
			// redirect 요청 주소는 그대로
			// redirect 된 서버 측 메소드에서 연결해주는 화면에서 사용할 수 있도록 전달 (model 저장됨)
			// request.getParameter에서 확인 x
		
		return "redirect:/re/re2";
	}
}
