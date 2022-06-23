package com.coding.gallery.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.coding.gallery.domain.HttpResponse;
import com.coding.gallery.domain.User;
import com.coding.gallery.service.UserService;

@Controller
public class UserController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;
	
	// 로그인
	@GetMapping("/loginProc")
	public void login() {
		
	}
	
	// 회원가입
	@PostMapping("/signup")
	public ResponseEntity<HttpResponse> signup(@RequestBody User userDto) {
		
		log.info("#### Sign up Mehtod Start");
		
		User user = new User();
		HttpResponse httpRes = new HttpResponse();
		
		httpRes.setMessage("Sign Up");
		
		try {
			if(userService.duplicate(userDto.getEmail())) {
				user = userService.signup(userDto);
				return ResponseEntity.status(200).body(httpRes);
			} else {
				return ResponseEntity.status(400).body(httpRes);
			}
		} catch(Exception e) {
			log.warn(e.getMessage());
			httpRes.setMessage(e.getMessage());
			return ResponseEntity.status(400).body(httpRes);
		} finally {
			log.info("### Sign up Mehtod End");
			log.info(user.toString());
		}
		
	}
	
	// 프로필
	@GetMapping("/profile")
	public ResponseEntity<HttpResponse> profile(@RequestParam String email) {
		
		log.info("### Profile Method Start");
		
		Optional<User> user = null;
		HttpResponse httpRes = new HttpResponse();
		httpRes.setMessage("Profile");
		
		try {
			user = userService.profile(email);
			user.get().setPw(null);
			httpRes.setUser(user);
			return ResponseEntity.status(200).body(httpRes);
		} catch(Exception e) {
			log.warn(e.getMessage());
			return ResponseEntity.status(400).body(httpRes);
		} finally {
			log.info("### Profile Method End");
			log.info(user.toString());
			
		}
		
	}
}
