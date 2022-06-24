package com.coding.gallery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@RestController
public class LoginController {
	 
	/*
	@GetMapping("/login")
	public String login() {
		log.info("=======================> login()");
		log.info("=======================> login()");
		log.info("=======================> login()");
		log.info("=======================> login()");
		log.info("=======================> login()");
		return "Test";
	}
	*/
	
	@PostMapping("/loginProc")
	public void loginProc() {
		log.info("=======================> loginProc()");
		log.info("=======================> loginProc()");
		log.info("=======================> loginProc()");
		log.info("=======================> loginProc()");
		log.info("=======================> loginProc()");
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
