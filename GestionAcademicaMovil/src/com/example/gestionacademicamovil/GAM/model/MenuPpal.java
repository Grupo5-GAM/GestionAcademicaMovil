package com.example.gestionacademicamovil.GAM.model;

public class MenuPpal {

	private String text1;
	private String text2;
	
	public MenuPpal(String text1,String text2)
	{
		this.setText1(text1);
		this.setText2(text2);
	}

	public String getText1() {
		return text1;
	}

	public void setText1(String text1) {
		this.text1 = text1;
	}

	public String getText2() {
		return text2;
	}

	public void setText2(String text2) {
		this.text2 = text2;
	}
	
	
}
