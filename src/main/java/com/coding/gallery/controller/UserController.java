package com.coding.gallery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
	
	// 로그인
	@GetMapping("/login")
	public void login() {
		
	}
	
	// 회원가입
	@PostMapping("/signup")
	public void signup() {
		
	}
	
	// 프로필
	@GetMapping("/profile")
	public void profile() {
		
	}
}
