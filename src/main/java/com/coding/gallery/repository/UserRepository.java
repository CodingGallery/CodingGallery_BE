package com.coding.gallery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coding.gallery.domain.User;

public interface UserRepository extends JpaRepository<User, String>{
	
	User findByEmail(String email);
	
}
