package com.coding.gallery.service;

import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
	public Optional<User> profile(String email) {
		
		Optional<User> user = userRepo.findByEmail(email);
		
		byte[] profileImg = Base64.getDecoder().decode(user.get().getProfile_img());
		
		user.get().setProfile_img(new String(profileImg));
		
		return user;
	}
	
	@SuppressWarnings("static-access")
	public boolean duplicate(String email) {
		
		Optional<User> user = userRepo.findByEmail(email);
		
		if(user.empty() != null) {
			return false;
		} else {
			return true;
		}
		
	}

	@Override
	public User loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Optional<User> result = userRepo.findByEmail(email);
		
		if(result != null) {
			return new User(result.get().getEmail(), result.get().getPw(), result.get().getName(),
					result.get().getPhone(), result.get().getProfile_img(), result.get().getJoin_date(), result.get().getRole());
		}
		
		return null;
	}

}
