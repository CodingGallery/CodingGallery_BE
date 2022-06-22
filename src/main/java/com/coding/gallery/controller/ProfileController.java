package com.coding.gallery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@RequestMapping("/profile/")
public class ProfileController {
	
	@GetMapping("/")
	public void index() {
		log.info("=======================> index");
		log.info("=======================> index");
		log.info("=======================> index");
		log.info("=======================> index");
		log.info("=======================> index");
	}
	 
	/*
	@GetMapping("/artist")
	public String forArtist() {
		return "artist";
	}
	
	@GetMapping("/artwork")
	public String forArtWork() {
		return "artwork";
	}
	
	@GetMapping("/exhibition")
	public String forExhibition() {
		return "exhibition";
	}
	*/
}
