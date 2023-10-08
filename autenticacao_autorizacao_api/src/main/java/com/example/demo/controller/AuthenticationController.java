package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dto.AuthenticationDTO;

@RestController
@RequestMapping("/auth")
@SuppressWarnings("rawtypes")
public class AuthenticationController {
	
	
	@PostMapping("/login")
	public ResponseEntity login(@RequestBody AuthenticationDTO data) {
		return null;
	}
	
}
