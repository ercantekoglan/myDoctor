package com.app.mydoctor.security;


import org.springframework.security.core.userdetails.UserDetails;

import com.app.mydoctor.domain.User;

public class SecurityUser extends User implements UserDetails {

	private static final long serialVersionUID = 821320911666648387L;

	public SecurityUser() {
	}

	public SecurityUser(User user) {
		this.setAuthorities(user.getAuthorities());
		this.setUserIdd(user.getUserIdd());
		this.setPassword(user.getPassword());
		this.setUsername(user.getUsername());
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
