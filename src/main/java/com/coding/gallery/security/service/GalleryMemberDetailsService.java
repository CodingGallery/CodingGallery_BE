package com.coding.gallery.security.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.coding.gallery.entity.GalleryMember;
import com.coding.gallery.repository.GalleryMemberRepository;
import com.coding.gallery.security.dto.GalleryAuthMemberDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
@RequiredArgsConstructor
public class GalleryMemberDetailsService implements UserDetailsService {
	
	private final GalleryMemberRepository galleryMemberRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		log.info("GalleryMemberDetailsService ===================================================================================");
		log.info("GalleryMemberDetailsService loadUserByUsername : " + username);
		
		Optional<GalleryMember> result = galleryMemberRepository.findByEmail(username);
		

		/*
		if(result.isPresent()) {
			throw new UsernameNotFoundException("Check UserName");
		}
		*/
		
		GalleryMember galleryMember = result.get();

		//log.info("GalleryMemberDetailsService Password : " + galleryMember.getPassword());
		log.info("GalleryMemberDetailsService GalleryMember : " + galleryMember.toString());
		log.info("GalleryMemberDetailsService ===================================================================================");
		
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(galleryMember.getRole()));

		GalleryAuthMemberDTO galleryAuthMember = new GalleryAuthMemberDTO(
					galleryMember.getEmail(),
					galleryMember.getPassword(),
					authorities
		);
		
		galleryAuthMember.setName(galleryMember.getName());
		
		return galleryAuthMember;
		
	}
}
