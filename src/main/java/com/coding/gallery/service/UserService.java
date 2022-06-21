package com.coding.gallery.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.coding.gallery.domain.User;
import com.coding.gallery.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {
	
	private static final Logger log = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	UserRepository userRepo;
	
	// 로그인
	public void login() {
		
	}
	
	// 회원가입
	public User signup(User userDto) {
		
		log.info("#### UserService Signup Method Start");
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		BCryptPasswordEncoder pwEncoder = new BCryptPasswordEncoder();
		
		User userDao = new User(userDto.getEmail(), pwEncoder.encode(userDto.getPw()),
				userDto.getName(), userDto.getPhone(), userDto.getImage(), sdf.format(date), "MEMBER", null, null);
		try {
			userRepo.save(userDao);
		} catch(Exception e) {
			log.warn(e.getMessage());
		}
		
		return userDao;		
	}
	
	// 프로필
	public User profile(String email) {
		return userRepo.findByEmail(email);
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return null;
	}

}
