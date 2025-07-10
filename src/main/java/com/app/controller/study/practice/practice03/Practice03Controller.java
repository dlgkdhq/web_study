package com.app.controller.study.practice.practice03;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.dto.study.practice.practice03.Beverage;

@Controller
@RequestMapping("/practice03")
public class Practice03Controller {

	// /practice03/request1-x?item=americano&type=coffee
	
	@GetMapping("/request1-1")
	public String request1(HttpServletRequest request){
		System.out.println("/request1-1 요청");
		System.out.println(request.getParameter("item"));
		System.out.println(request.getParameter("type"));
		
		return "practice/practice03/request1";
	}
	
	@GetMapping("/request1-2")
	public String request2(@RequestParam String item, @RequestParam String type) {
		System.out.println("/request1-2 요청");
		System.out.println(item);
		System.out.println(type);
		
		return "practice/practice03/request1";
	}
	
	@GetMapping("/request1-3")
	public String request3(@RequestParam Map<String, String> paramMap) {
		System.out.println("/request1-3 요청");
		System.out.println(paramMap.get("item"));
		System.out.println(paramMap.get("type"));
		
		return "practice/practice03/request1";
	}
	
	@GetMapping("/request1-4")
	public String request4(@ModelAttribute Beverage beverage) {
		System.out.println("/request1-4 요청");
		
		System.out.println(beverage);
		
		return "practice/practice03/request1";
	}
	
	@RequestMapping("/viewData1-1")
	public String viewData1(HttpServletRequest request) {
		System.out.println("/viewData1-1 요청");
		
		request.setAttribute("name", "아메리카노");
		request.setAttribute("type", "커피");
		
		return "practice/practice03/viewData1";
	}
	
	@RequestMapping("/viewData1-2")
	public String viewData2(Model model) {
		System.out.println("/viewData1-2 요청");
		
		model.addAttribute("name", "라떼");
		model.addAttribute("type", "coffee");
		
		return "practice/practice03/viewData1";
	}
	
	@RequestMapping("/viewData1-3")
	public ModelAndView viewData3() {
		System.out.println("/viewData1-3 요청");
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("practice/practice03/viewData1");
		mav.addObject("name", "민트티");
		mav.addObject("type", "tea");
		
		return mav;
	}
	
	@RequestMapping("/viewData1-4")	//선생님 git 참고~
	public String viewData4(Model model) {
		System.out.println("/viewData1-4 요청");
		
		Beverage drinkItem = new Beverage();
		
		drinkItem.setItem("아메리카노");
		drinkItem.setType("coffe");
		
		model.addAttribute("drinkItem", drinkItem);
		
		return "practice/practice03/viewData1";
	}
}
