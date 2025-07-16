package com.app.controller.study.practice.practice10;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Practice10Controller {

	@GetMapping("/practice10/A")
	public String A(Model model) {
		
		model.addAttribute("fromA", "FromA");
		
		return "practice/practice10/A";
	}

	@GetMapping("/practice10/B")
	public String B(HttpSession session) {
	//public String B(HttpServletRequest request){
		//HttpSession session = request.getSession();
		
		session.setAttribute("fromBMsg", "FromB");
		
		// request / session 				/ application
		// request : 각 요청별 독립
		// session : 브라우저(사용자) 별로 구분 사용
		
		return "practice/practice10/B";
	}
}
