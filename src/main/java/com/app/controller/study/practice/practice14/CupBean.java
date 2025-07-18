package com.app.controller.study.practice.practice14;

import lombok.Data;

@Data
public class CupBean {

	CoffeeBean coffeeBean;
	
	//생성자 방식
	public CupBean(CoffeeBean coffeeBean) {
		this.coffeeBean = coffeeBean;
	}
}
