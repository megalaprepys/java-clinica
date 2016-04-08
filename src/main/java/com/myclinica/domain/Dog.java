package com.myclinica.domain;

public class Dog extends Animal implements Pet{

	protected Dog(String nickname) {
		super(nickname);						
	}

	public void eating() {
		System.out.println("Dat eats meat...");
		
	}



}
