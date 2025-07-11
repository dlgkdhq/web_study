package com.app.controller.study.practice.practice04;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.dto.study.practice.practice04.CategoryDTO;
import com.app.dto.study.practice.practice04.TransferItem;

@Controller
@RequestMapping("/practice04")
public class Practice04Controller {

	//  /practice04/request1-x?category=100&product=4000
	
	@RequestMapping("/request1-1")
	public String request1_1(HttpServletRequest request) {
		System.out.println("/request1-1 요청");
		
		System.out.println(request.getParameter("category"));
		System.out.println(request.getParameter("product"));
		
		return "practice/practice04/req";
	}
	
	@RequestMapping("/request1-2")
	public String request1_2(@RequestParam String category, @RequestParam String product) {
		System.out.println("/request1-2 요청");
		
		System.out.println(category);
		System.out.println(product);
		
		return "practice/practice04/req";
	}
	
	@RequestMapping("/request1-3")
	public String request1_3(@ModelAttribute CategoryDTO categoryDTO) {
		System.out.println("/request1-3 요청");
		
		System.out.println(categoryDTO);
		
		return "practice/practice04/req";
	}
	
	@RequestMapping("/request1-4")
	public String request1_4(@RequestParam Map<String, String> paramMap) {
		System.out.println("/request1-4 요청");
		
		System.out.println(paramMap.get("category"));
		System.out.println(paramMap.get("product"));
		
		return "practice/practice04/req";
	}
	
	@RequestMapping("/viewData1-1")
	public String viewData1(HttpServletRequest request) {
		System.out.println("/viewData1-1 요청");
		
		request.setAttribute("response001", "식품");
		request.setAttribute("response099", "피자");
		
		return "practice/practice04/viewData";
	}
	
	@RequestMapping("/viewData1-2")
	public String viewData2(Model model) {
		System.out.println("/viewData1-2 요청");
		
		model.addAttribute("response001", "가구");
		model.addAttribute("response099", "소파");
		
		return "practice/practice04/viewData";
	}
	
	@RequestMapping("/viewData1-3")
	public ModelAndView viewData3() {
		System.out.println("/viewData1-3 요청");
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("practice/practice04/viewData");
		mav.addObject("response001", "가전제품");
		mav.addObject("response099", "에어컨");
		
		return mav;
	}
	
	@RequestMapping("/viewData1-4")
	public String viewData4(Model model) {
		System.out.println("/viewData1-4 요청");
		
		model.addAttribute("response001", "가전제품");
		model.addAttribute("response099", "에어컨");
		
		TransferItem transferItem = new TransferItem();
		
		transferItem.setValue001("가전제품");
		transferItem.setValue099("냉장고");
		
		model.addAttribute("transferItem", transferItem);
		
		return "practice/practice04/viewData";
	}
}
