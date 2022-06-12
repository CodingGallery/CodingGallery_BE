package com.coding.gallery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	// Main 화면
	@GetMapping("/")
	public static void home() {
		
	}

}
