package com.mydoctor.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfiguration{
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public static PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationManager authenticationManager
	(HttpSecurity http) 
	  throws Exception {
	    return http.getSharedObject(AuthenticationManagerBuilder.class)
	      .userDetailsService(userDetailsService)
	      .passwordEncoder(passwordEncoder)
	      .and()
	      .build();
	}
	



	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
			.antMatchers("/resources/**", "**/register.js").permitAll()
			.antMatchers("/","/index", "/register", "/login").permitAll()
			.anyRequest().permitAll()
        .and()
        	.formLogin()
        	.loginPage("/login")
        	.defaultSuccessUrl("/dashboard",true)
        	.failureUrl("/login?error")
        	.permitAll()
        .and()
        	.logout()
        	.logoutSuccessUrl("/index")
        	.permitAll();
		
		return http.build();
	
}
}



///* Pages that require authentication */
//.authorizeHttpRequests()
//.antMatchers().hasRole("PATIENT")
//.antMatchers("/patient-dashboard","/patient-profile" )
//.authenticated()
//.and()
///* Pages that require authentication */
//	.authorizeHttpRequests()
//	.antMatchers().hasRole("DOCTOR")
//	.antMatchers("/doctor-dashboard","/doctor-profile" )
//	.authenticated();
