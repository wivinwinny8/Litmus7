package com.litmus7.userregistration.model;

public class User {
	private String username;
	private int age;
	private String email;
	private String password;

	public User(String username, int age, String email, String password) {
		this.username = username;
		this.age = age;
		this.email = email;
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public int getAge() {
		return this.age;
	}

	public String getEmail() {
		return this.email;
	}

	public String getPassword() {
		return this.password;
	}
}
