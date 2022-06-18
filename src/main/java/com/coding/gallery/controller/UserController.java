package com.coding.gallery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.coding.gallery.domain.User;
import com.coding.gallery.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	// 로그인
	@GetMapping("/login")
	public void login() {
		
	}
	
	// 회원가입
	@PostMapping("/signup")
	public void signup(@RequestBody User user) {
		
		userService.signup(user);
		
	}
	
	// 프로필
	@GetMapping("/profile")
	public void profile() {
		
	}
}
