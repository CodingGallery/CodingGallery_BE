package com.coding.gallery.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.coding.gallery.security.filter.GalleryAuthenticationFailureHandler;
import com.coding.gallery.security.filter.GalleryAuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class GallerySecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	 
	@Bean
	public GalleryAuthenticationSuccessHandler successHandler()
	{
		return new GalleryAuthenticationSuccessHandler();
	}
	
	@Bean
	public GalleryAuthenticationFailureHandler failureHandler()
	{
		return new GalleryAuthenticationFailureHandler();
	}
	
	@Override
	protected void configure(HttpSecurity security) throws Exception {

		security.csrf().disable();
		
		security.authorizeHttpRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/profile/**").authenticated()
			.anyRequest().permitAll()
			.and()
			.formLogin()
				.loginPage("/login")
				.loginProcessingUrl("/loginProc")
				.usernameParameter("username") 
				.passwordParameter("userpassword")
				//.defaultSuccessUrl("/")
			    .successHandler(successHandler())
			    .failureHandler(failureHandler())
				.and()
			.logout()
				.logoutUrl("/logoutProc")
				.logoutSuccessUrl("/");
		
		//security.exceptionHandling().accessDeniedPage("/accessDenied");
	}
}
