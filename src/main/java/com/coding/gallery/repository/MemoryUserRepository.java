package com.coding.gallery.repository;

import com.coding.gallery.domain.User;

public class MemoryUserRepository implements UserRepository{
	
	private User user ;

	@Override
	public User save(User user) {
		this.user = new User(user);
		return this.user;
	}
	
	public void clear() {
		user = new User();
	}

}
