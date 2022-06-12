package com.coding.gallery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coding.gallery.domain.Image;

public interface ImageReository extends JpaRepository<Image, Image>{

}
