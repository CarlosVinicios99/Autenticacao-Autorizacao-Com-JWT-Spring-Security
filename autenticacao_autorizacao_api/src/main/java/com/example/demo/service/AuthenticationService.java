package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.config.security.TokenService;
import com.example.demo.model.User;
import com.example.demo.model.dto.AuthenticationDTO;
import com.example.demo.model.dto.LoginResponseDTO;
import com.example.demo.model.dto.RegisterDTO;
import com.example.demo.repository.UserRepository;

@Service
@SuppressWarnings("rawtypes")
public class AuthenticationService {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private UserRepository userRepository;
	
	public ResponseEntity login(AuthenticationDTO data) {
		try {
			var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
			var auth = this.authenticationManager.authenticate(usernamePassword);
			var token = tokenService.generateToken((User) auth.getPrincipal());
			return ResponseEntity.ok(new LoginResponseDTO(token));
		}
		catch(Exception error) {
			System.out.println(error.getMessage());
			return ResponseEntity.badRequest().build();
		}
	}
	
	public ResponseEntity register(RegisterDTO data) {
		if(this.userRepository.findByLogin(data.login()) != null) {
			return ResponseEntity.badRequest().build();
		}
		
		String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
		User newUser = new User(data.login(), encryptedPassword, data.role());
		this.userRepository.save(newUser);
		
		return ResponseEntity.ok().build();
		
	}
	
}
