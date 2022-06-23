package com.coding.gallery.domain;

import java.util.Optional;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class HttpResponse {
	
	private String message;
	private Optional<User> user;

}
