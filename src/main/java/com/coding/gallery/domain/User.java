package com.coding.gallery.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User implements UserDetails {
	
	@Id
	private String email;
	private String pw;
	private String name;
	private String phone;
	private String profile_img;
	private String join_date;
	private String role;
	
	public User(Optional<User> user) {
		this.email = user.get().getEmail();
		this.pw = user.get().getPw();
		this.name = user.get().getName();
		this.phone = user.get().getPhone();
		this.profile_img = user.get().getProfile_img();
		this.join_date = user.get().getJoin_date();
		this.role = user.get().getRole();
	}
	
	@Override
	public String toString() {
		return "User [ email : " + email + ", name : " + name + ", phone : " + phone + ", join_date : " + join_date + " ]";
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		Collection<GrantedAuthority> collect = new ArrayList<>();
		
		collect.add(new SimpleGrantedAuthority("MEMBER"));
		return collect;
	}

	@Override
	public String getPassword() {
		return this.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

}