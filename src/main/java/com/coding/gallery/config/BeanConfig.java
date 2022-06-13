package com.coding.gallery.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.coding.gallery.repository.MemoryUserRepository;
import com.coding.gallery.repository.UserRepository;

@Configuration
public class BeanConfig {
	
	@Bean
	public UserRepository userRepository() {
		return new MemoryUserRepository();
	}

}
