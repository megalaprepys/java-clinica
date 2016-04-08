package com.myclinica.domain;

public class Animal {
	
	private String nickname;
	private String sex;
	
	protected Animal(String nickname) {
		this.setNickname(nickname);
	}

	protected String getNickname() {
		return nickname;
	}

	protected void setNickname(String nickname) {
		this.nickname = nickname;
	}

	protected String getSex() {
		return sex;
	}
	
	/**
	 * 
	 * @param sex gender of pet (dog or cat)
	 */
	protected void setSex(String sex) {
		this.sex = sex;
	}

}
