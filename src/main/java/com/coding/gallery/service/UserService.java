package com.coding.gallery.service;

import java.text.SimpleDateFormat;
import java.util.Base64;
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
		
		// password 암호화
		BCryptPasswordEncoder pwEncoder = new BCryptPasswordEncoder();
		
		// Base64 URL 암호화
		String profileImg = Base64.getUrlEncoder().encodeToString(userDto.getProfile_img().getBytes());
		
		User userDao = new User(userDto.getEmail(), pwEncoder.encode(userDto.getPw()),
				userDto.getName(), userDto.getPhone(), profileImg, sdf.format(date), "MEMBER");
		try {
			userRepo.save(userDao);
		} catch(Exception e) {
			log.warn(e.getMessage());
		}
		
		return userDao;		
	}
	
	// 프로필
	public User profile(String email) {
		
		User user = userRepo.findByEmail(email);
		
		byte[] profileImg = Base64.getDecoder().decode(user.getProfile_img());
		
		user.setProfile_img(new String(profileImg));
		
		return user;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return null;
	}

}
