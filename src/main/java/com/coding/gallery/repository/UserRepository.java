package com.coding.gallery.repository;

import com.coding.gallery.domain.User;

public interface UserRepository {
	
	// User 객체 저장하는 method
	User save(User user);
}
