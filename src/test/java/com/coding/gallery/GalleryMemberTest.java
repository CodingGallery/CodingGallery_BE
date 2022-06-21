package com.coding.gallery;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.coding.gallery.entity.GalleryMember;
import com.coding.gallery.repository.GalleryMemberRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class GalleryMemberTest {
	
	@Autowired
	private GalleryMemberRepository repository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Test
	public void testRead() {
		
		log.info("========================================================");
		
		Optional<GalleryMember> result = repository.findByEmail("test@test.com");
		
		log.info("========================================================");
		GalleryMember galleryMember = result.get();
		
		log.info(galleryMember.toString());
		
		System.out.println(galleryMember);
	}

}
