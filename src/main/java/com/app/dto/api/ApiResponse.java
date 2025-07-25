package com.app.dto.api;

import lombok.Data;

@Data
public class ApiResponse<T> {	//최종 응답 객체
	ApiResponseHeader header;	//응답 시 관련 결과 코드
	T body;	//응답 시 실제 넘기는 데이터 관련 정보
	
	//제네릭 Generic 타입을 고정하지 않고 일반화

}
