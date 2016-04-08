package com.myclinica.domain;

public class Animal {
	
	private String nickname;
	
	protected Animal(String nickname) {
		this.setNickname(nickname);
	}

	protected String getNickname() {
		return nickname;
	}

	protected void setNickname(String nickname) {
		this.nickname = nickname;
	}

}
