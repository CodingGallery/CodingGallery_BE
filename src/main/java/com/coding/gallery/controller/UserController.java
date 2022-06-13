package com.coding.gallery.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.coding.gallery.domain.User;
import com.coding.gallery.service.UserService;

@Controller
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userSerivce;
	
	// 로그인
	@GetMapping("/login")
	public void login() {
		
		log.info("#####################");
		
	}
	
	// 회원가입
	@PostMapping("/signup") 
	public boolean signup(@RequestBody User user) {
		
		log.info("### Signup Start");
		
		// 회원가입 성공 시 Http Status에 OK 로 return 줌.
		if(userSerivce.signupService(user)) {
			log.info("### Signup Success ###");
			return true;
		// 회원가입 실패 시 Http Status에 return 값 미정. ( false 인데 false가 없음. )
		} else {
			log.info("### Signup End ###");
			return false;
		}
	}
	
	// 프로필
	@GetMapping("/profile")
	public void profile() {
		
	}
}
