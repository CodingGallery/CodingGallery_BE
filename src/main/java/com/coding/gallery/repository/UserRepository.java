package com.coding.gallery.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coding.gallery.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, User>{

	List<User> findById();
}
