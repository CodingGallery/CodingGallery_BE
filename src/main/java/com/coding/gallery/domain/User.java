package com.coding.gallery.domain;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class User {
	
	private String id;
	private String name;
	private int age;
	private String pw;
	private String phone;

}
