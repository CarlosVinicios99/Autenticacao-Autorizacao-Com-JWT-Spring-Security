package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dto.AuthenticationDTO;
import com.example.demo.model.dto.RegisterDTO;
import com.example.demo.service.AuthenticationService;

@RestController
@RequestMapping("/auth")
@SuppressWarnings("rawtypes")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationService authenticationService;
	
	@PostMapping("/login")
	public ResponseEntity login(@RequestBody @Validated AuthenticationDTO data) {
		return authenticationService.login(data);
	}
	
	@PostMapping("/register")
	public ResponseEntity register(@RequestBody RegisterDTO data) {
		return authenticationService.register(data);
	}
	
}
