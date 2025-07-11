package com.app.controller.study.practice.practice05;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/practice05")
public class Practice05Controller {

	/*
	아래 요청 경로에 따라서 화면에 표시될 페이지와 정보를 작성하세요!

	localhost:8080/practice05/pathA -> 퀴즈 페이지 A 상품정보 표시
	localhost:8080/practice05/pathB -> 퀴즈 페이지 B 상품정보 표시
	localhost:8080/practice05/pathCommon/A -> 퀴즈 페이지 A 상품정보 표시
	localhost:8080/practice05/pathCommon/B -> 퀴즈 페이지 B 상품정보 표시
	 */
	
	// 1) 경로별 각자 개별 페이지를 사용하는 케이스
	
	/*
	// 2) (상품기준) A정보, B정보 2개의 페이지를 기준으로 사용하는 케이스
	@RequestMapping("/pathA")
	public String pathA() {
		return "practice/practice05/A";
	}
	
	@RequestMapping("/pathB")
	public String pathB() {
		return "practice/practice05/B";
	}
	
	@RequestMapping("/pathCommon/A")
	public String pathCommonA() {
		return "practice/practice05/A";
	}
	
	@RequestMapping("/pathCommon/B")
	public String pathCommonB() {
		return "practice/practice05/B";
	}
	*/
	// + 경로 모아서..
	@RequestMapping(value = {"/pathA", "/pathCommon/A"})
	public String pathA() {
		return "practice/practice05/A";
	}
	
	@RequestMapping(value = {"/pathB","/pathCommon/B"})
	public String pathB() {
		return "practice/practice05/B";
	}
	
	/*
	// 3) pathA, pathB는 각자 페이지, pathCommon은 공통 페이지에 동적 데이터 전달
	@RequestMapping("/pathA")
	public String pathA() {
		return "practice/practice05/A";
	}
	
	@RequestMapping("/pathB")
	public String pathB() {
		return "practice/practice05/B";
	}
	
	@RequestMapping("/pathCommon/A")
	public String pathCommonA(Model model) {
		
		model.addAttribute("productName", "A");
		
		return "practice/practice05/pathCommon/common";
	}
	
	@RequestMapping("/pathCommon/B")
	public String pathCommonB(Model model) {
		
		model.addAttribute("productName", "B");
		
		return "practice/practice05/pathCommon/common";
	}
	
	
	// + pathCommon/pathVariable 형태로 사용
	@RequestMapping("/pathCommon/{productName}")
	public String pathCommonA(@PathVariable String productName, Model model) {
		
		// 경로에 있는 값 productName으로 DB조회
		// 올바른 값인지 검증
		// 그 정보에 맞는 데이터 획득 후 화면에 전달
		
		model.addAttribute("productName", productName);
		
		return "practice/practice05/pathCommon/common";
	}
	*/
	
	/*
	// 4) 모든 경로가 동일한 공통 페이지 사용 케이스
	@RequestMapping("/pathA")
	public String pathA(Model model) {
		model.addAttribute("productName", "A");
		return "practice/practice05/pathCommon/common";
	}
	
	@RequestMapping("/pathB")
	public String pathB(Model model) {
		model.addAttribute("productName", "B");
		return "practice/practice05/pathCommon/common";
	}
	
	@RequestMapping("/pathCommon/A")
	public String pathCommonA(Model model) {
		model.addAttribute("productName", "A");
		return "practice/practice05/pathCommon/common";
	}
	
	@RequestMapping("/pathCommon/B")
	public String pathCommonB(Model model) {
		model.addAttribute("productName", "B");
		return "practice/practice05/pathCommon/common";
	}
	*/
}
