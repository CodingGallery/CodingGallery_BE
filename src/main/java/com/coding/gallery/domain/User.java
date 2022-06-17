package com.coding.gallery.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Entity
@Getter
@AllArgsConstructor
public class User {
	
	@Id
	private String email;
	private String pw;
	private String name;
	private String phone;
	private String image;
	private String join_date;

}