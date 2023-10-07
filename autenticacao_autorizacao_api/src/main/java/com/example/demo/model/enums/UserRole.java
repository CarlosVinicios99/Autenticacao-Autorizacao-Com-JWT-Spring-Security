package com.example.demo.model.enums;

public enum UserRole {
	
	ADMIN("admin"),
	USER("user");
	
	private String role;
	
	UserRole(String role) {
		this.role = role;
	}
	
	public String getRole() {
		return role;
	}
}
