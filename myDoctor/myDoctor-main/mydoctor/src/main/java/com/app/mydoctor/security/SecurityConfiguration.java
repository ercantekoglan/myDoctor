package com.app.mydoctor.security;

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
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration{
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	
	@Bean
	public AuthenticationManager authenticationManager(HttpSecurity http) 
	  throws Exception {
	    return http.getSharedObject(AuthenticationManagerBuilder.class)
	      .userDetailsService(userDetailsService)
	      .passwordEncoder(passwordEncoder)
	      .and()
	      .build();
	}
	
//	@Bean
//	public WebSecurityCustomizer webSecurityCustomizer() {
//	    return (web) -> web.debug(securityDebug)
//	      .ignoring()
//	      .antMatchers("/css/**", "/js/**", "/img/**", "/lib/**", "/favicon.ico");
//	}
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
     
        http
        
        /* Login configuration */
        .formLogin()
        .loginPage("/login")
        .defaultSuccessUrl("/dashboard") // user's home page, it can be any URL
        .permitAll() // Anyone can go to the login page
        /* Logout configuration */
        .and()
        .logout()
        .logoutSuccessUrl("/index").permitAll() // append a query string value
        /* Pages that can be viewed without having to log in */
        .and()
        .authorizeRequests()
        .antMatchers("/","/login","/index", "/register","/css/**", "/js/**", "/images/**","/error")
        .permitAll()
        /* Pages that require authentication */
        .and()
        .authorizeRequests()
        .antMatchers("/dashboard").hasAnyRole("PATIENT")
        .antMatchers("/personal").hasAnyRole("PATIENT")
        .anyRequest()
        .authenticated();
 
        return http.build();
    }
}
