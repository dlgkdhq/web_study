package com.app.controller.customer;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.common.CommonCode;
import com.app.dto.user.User;
import com.app.service.user.UserService;

@Controller
public class CustomerController {

	// 사용자서비스 (계정에 관련된 것을 통합 관리 : 고객서비스/관리자서비스)

	@Autowired
	UserService userService;

	@GetMapping("/customer/signup")
	public String signup() {
		return "customer/signup";
	}

	@PostMapping("/customer/signup")
	public String signupAction(User user) {

		// 사용자 회원가입 -> 저장
		int result = userService.saveCustomerUser(user);

		if (result > 0) { // 성공
			return "redirect:/main";
		} else { // 실패
			return "customer/signup";
		}
	}

	// @GetMapping("/customer/login")
	@GetMapping("/customer/signin")
	public String signin() {
		return "customer/signin";
	}

	@PostMapping("/customer/signin")
	public String signinAction(User user, HttpSession session) {

		System.out.println("사용자가 입력한 아이디 비번 ");
		System.out.println(user); // id pw

		// 사용자가 입력한 id, pw 맞냐! DB에 존재하냐
		// 서비스에서 비교시, userType 까지 비교
		user.setUserType(CommonCode.USER_USERTYPE_CUSTOMER);
		User loginUser = userService.checkUserLogin(user);

		if (loginUser == null) { // 로그인 실패 ( 뭐라도 틀린게 있다 )
			System.out.println("로그인 실패");

			return "customer/signin";
		} else { // 아이디 맞고 비번 맞고 userType도 일치하고 -> 로그인 성공
			System.out.println("로그인 성공");

			// 현재 로그인 성공한 사용자 아이디 -> session 영역에 저장
			session.setAttribute("loginUserId", loginUser.getId());

			// return "redirect:/customer/mypage"; //로그인 성공한 후, 마이페이지로 이동
			return "redirect:/main"; // 로그인 성공한 후, 메인 페이지로
		}
	}
}
