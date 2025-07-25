package com.app.dto.study.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor	//기본 생성자
@AllArgsConstructor //모든 매개변수 받는 생성자
public class ApiMenu {
	String name;
	int price;
}
