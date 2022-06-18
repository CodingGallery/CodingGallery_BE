package com.coding.gallery.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coding.gallery.domain.User;

public interface UserRepository extends JpaRepository<User, String>{
	
	Optional<User> findByEmail(String email);
	
}
