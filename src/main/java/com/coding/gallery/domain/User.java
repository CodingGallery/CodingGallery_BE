package com.coding.gallery.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {
	
	@Id
	private String email;
	private String pw;
	private String name;
	private String phone;
	private String image;
	private String join_date;
	private String role;
	private String moddate = null;
	private String regedate = null;
	
	@Override
	public String toString() {
		return "User [ email : " + email + " name : " + name + " phone : " + phone + " join_date : " + join_date + " ]";
	}

}