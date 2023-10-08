package com.example.demo.model.dto;

import com.example.demo.model.enums.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
	
}
