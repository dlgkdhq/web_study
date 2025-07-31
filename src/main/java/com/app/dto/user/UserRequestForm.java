package com.app.dto.user;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserRequestForm {
	// 특정 화면에서 요청 들어온 데이터를 담아야 하는 용도의 DTO
	// 화면별로 요청 시 검증해야하는 기준이 다른 경우
	// 요청Form 별 객체를 구분해서 유효성 구분 작성
	
	// 필수입력. 빈칸 X
	@NotBlank(message = "이거 아이디 필수얀")
	String id;

	//admin/users/add 아이디 이름 비번입력 X
	// 입력 길이 제한
	String pw;
	
	@NotBlank(message = "이름 필수입력!")
	String name;
	String userType;
}

//UserRequestForm 담긴 -> User 객체에 옮겨 담아서 -> userService.saveUser