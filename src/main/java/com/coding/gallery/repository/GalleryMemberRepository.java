package com.coding.gallery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import com.coding.gallery.entity.GalleryMember;

public interface GalleryMemberRepository extends JpaRepository<GalleryMember, String>{

	Optional<GalleryMember> findByEmail(String email);
}
 