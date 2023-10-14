package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dto.AuthenticationDTO;
import com.example.demo.model.dto.RegisterDTO;
import com.example.demo.service.AuthenticationService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/auth")
@SuppressWarnings("rawtypes")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationService authenticationService;
	
	@Operation(
		summary = "Login",
		tags = {"Authentication"}
	)
	@PostMapping("/login")
	public ResponseEntity login(@RequestBody AuthenticationDTO data) {
		return authenticationService.login(data);
	}
	
	@Operation(
			summary = "Cadastra um novo Usuário",
			tags = {"Authentication"}
		)
	@PostMapping("/register")
	public ResponseEntity register(@RequestBody RegisterDTO data) {
		return authenticationService.register(data);
	}
	
}
