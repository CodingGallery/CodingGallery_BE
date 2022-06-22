package com.coding.gallery.security.dto;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import com.coding.gallery.entity.GalleryMember;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class GalleryAuthMemberDTO extends User {
	
	private static final long serialVersionUID = 1L;
	
	private String email;
	private String name;
	
	public GalleryAuthMemberDTO(GalleryMember galleryMember) {
		super(galleryMember.getEmail(), galleryMember.getPassword(), AuthorityUtils.createAuthorityList(galleryMember.getRole().toString()));
		this.email = galleryMember.getEmail();
		this.name = galleryMember.getName();
	}
}
