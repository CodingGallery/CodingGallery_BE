package com.coding.gallery.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	private String email;
	private String password;
	private String name;
	private String phone;
	private String image;
	
	public User(User user) {
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.name = user.getName();
		this.phone = user.getPhone();
		this.image = user.getImage();
	}
	
	@Override
	public String toString() {
		return "User [ email : " + this.getEmail() + ", name : " + this.getName() + ", phone : " + this.getPhone() + " ]";
	}

}