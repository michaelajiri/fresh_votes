package com.freshvotes.security;

import java.util.Set;

import org.springframework.security.core.userdetails.UserDetails;

import com.freshvotes.domain.User;

public class CustomUserDetails extends User implements UserDetails {

	private static final long serialVersionUID = -8787843940394575605L;
	
	public CustomUserDetails() {
	}

	public CustomUserDetails(User user) {
		this.setId(user.getId());
		this.setName(user.getName());
		this.setUsername(user.getUsername());
		this.setPassword(user.getPassword());
		this.setAuthorities(user.getAuthorities());
	}

	@Override
	public Set<Authority> getAuthorities() {
		return super.getAuthorities();
	}

	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		return super.getUsername();
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