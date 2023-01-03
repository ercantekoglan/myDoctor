package com.mydoctor.security;

import org.springframework.security.core.userdetails.UserDetails;
import com.mydoctor.domain.User;

public class SecurityPatient extends User implements UserDetails {
	private static final long serialVersionUID = -768590123482494682L;

	

	public SecurityPatient(User user) {
		this.setAuthorities(user.getAuthorities());
		this.setId(user.getId());
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
