package com.app.controller.study.practice.practice14;

import lombok.Data;

@Data
public class PlateBean {

	 DessertBean dessertBean;
	 
	 //setter 방식
	 public void setDessertBean(DessertBean dessertBean) {
		 this.dessertBean = dessertBean;
	 }
}
