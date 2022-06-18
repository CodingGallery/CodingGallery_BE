package com.coding.gallery.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.coding.gallery.domain.User;
import com.coding.gallery.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo;
	
	// 로그인
	public void login() {
		
	}
	
	// 회원가입
	public void signup(User user) {
		
		BCryptPasswordEncoder pwEncoder = new BCryptPasswordEncoder();
		
		user.setPw(pwEncoder.encode(user.getPw()));
		userRepo.save(user);
		
	}
	
	// 프로필
	public void profile() {
		
	}

//	@Override
//	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//		
//		Optional<User> userEntityWrapper = userRepo.findByEmail(email);
//		User userEntity = userEntityWrapper.get();
//		
//		List<GrantedAuthority> authorities = new ArrayList<>();
//		
//		if(("admin").equals(email)) {
//			authorities.add(new SimpleGrantedAuthority("ADMIN"));
//		} else {
//			authorities.add(new SimpleGrantedAuthority("MEMBER"));
//		}
//		
//		return new org.springframework.security.core.userdetails.User(userEntity.getEmail(), userEntity.getPw(), authorities);
//	}

}
