package com.coding.gallery.repository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.coding.gallery.domain.User;

@SpringBootTest
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository userRepo;
	
	@Test
	void signup() {
		
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		// given
		User user = new User("test@test.com", "test", "test", "test", "test", df.format(date), "ADMIN");

		// when
		userRepo.save(user);
		Optional<User> result = userRepo.findByEmail("test@test.com");
		
		// then
		Assertions.assertEquals(result.get().getName(), user.getName());
		
	}
	
}