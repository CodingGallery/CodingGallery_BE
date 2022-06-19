package com.coding.gallery.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coding.gallery.domain.User;
import com.coding.gallery.service.UserService;

@Controller
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;
	
	// 로그인
	@GetMapping("/login")
	public void login() {
		
	}
	
	// 회원가입
	@PostMapping("/signup")
	@ResponseBody
	public String signup(@RequestBody User userDto) {
		
		log.info("#### Sign up Mehtod Start");
		
		User user = userService.signup(userDto);
		log.info("#### Sign up Mehtod End");
		log.info(user.toString());
		
		return "End";
	}
	
	// 프로필
	@GetMapping("/profile")
	public void profile() {
		
	}
}
