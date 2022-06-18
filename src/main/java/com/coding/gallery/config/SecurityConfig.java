package com.coding.gallery.config;

//@SuppressWarnings("deprecation")
//@Configuration
//@EnableWebSecurity
public class SecurityConfig {
	
//	private UserService userService;
//	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//	
//	@Override
//	public void configure(WebSecurity web) {
//		web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/lib/**");
//	}
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		
//		http.authorizeRequests()
//				.antMatchers("/**")
//				.permitAll()
//			.and()
//				.formLogin()
//				.loginPage("/login")
//				.defaultSuccessUrl("/")
//				.permitAll()
//			.and()
//				.logout()
//				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//				.logoutSuccessUrl("/")
//				.invalidateHttpSession(true);
//			
//	}
	
//	@Override
//	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
//	}

}
