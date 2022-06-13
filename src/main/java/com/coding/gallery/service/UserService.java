package com.coding.gallery.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.coding.gallery.domain.User;
import com.coding.gallery.repository.UserRepository;

@Service
public class UserService {
	
	private static final Logger log = LoggerFactory.getLogger(UserService.class);
	private final UserRepository userRepo;
	
	public UserService(UserRepository userRepo) {
		this.userRepo = userRepo;
	};
	
	// 로그인
	public void loginService() {
		
	}
	
	// 회원가입
	public boolean signupService(User user) {
		
		try {
			log.debug("### User Save Start ###");
			userRepo.save(user);
			
			return true;
		} catch(Exception e) {
			log.warn(e.getMessage());
			return false;
		}
	}
	
	// 프로필
	public void profileService() {
		
	}

}
