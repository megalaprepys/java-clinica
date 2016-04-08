package com.myclinica.domain;

public class Cat extends Animal implements Pet {

	protected Cat(String nickname) {
		super(nickname);		
	}

	public void eating() {
		System.out.println("Cat eats fish...");		
	}	

}
