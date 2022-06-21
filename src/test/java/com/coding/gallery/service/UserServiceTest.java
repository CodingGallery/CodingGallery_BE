package com.coding.gallery.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.coding.gallery.domain.User;
import com.coding.gallery.repository.UserRepository;

@SpringBootTest
public class UserServiceTest {
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	UserService userService;
	
	@Test
	public void singup() {
		
		User user = new User("test@test.com", "test", "test", "test", "test", null, null, null, null);

		User user_test = userService.signup(user);
		BCryptPasswordEncoder pwEncoder = new BCryptPasswordEncoder();
		String check = "";
		
		if(pwEncoder.matches("test", user_test.getPw())) {
			check = "Equals";
		} else {
			check = "Not Equals";
		}
		
		Assertions.assertEquals(check, "Equals");
		
	}

}
