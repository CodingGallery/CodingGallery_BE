package com.coding.gallery.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.coding.gallery.domain.User;

public class MemoryUserRepositoryTest {
	
	MemoryUserRepository userRepo = new MemoryUserRepository();
	
	@BeforeEach
	public void beforeEach() {
		userRepo.clear();
	}
	
	@Test
	public void save() {
		
		// when
		User user = new User();
		
		// given
		user.setEmail("test@test.com");
		user.setPassword("password");
		user.setName("test");
		user.setPhone("010-1111-1111");
		user.setImage("Image");
		
		User result = userRepo.save(user);
		
		// then
		Assertions.assertThat(user.getEmail()).isEqualTo(result.getEmail());
	}
}