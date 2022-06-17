package com.coding.gallery.domain;

import java.util.Date;

import javax.persistence.Entity;

import lombok.Getter;

@Entity
@Getter
public class Image {
	
	private String email;
	private String name;
	private String image;
	private Date date;

}
