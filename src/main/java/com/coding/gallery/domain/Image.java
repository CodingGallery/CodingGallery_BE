package com.coding.gallery.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Image {
	
	private String email;
	private String name;
	private String image;
	private Date date;

}
