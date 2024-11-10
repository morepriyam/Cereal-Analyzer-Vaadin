package com.morepriyam.cereal_analyzer_vaadin.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.vaadin.flow.spring.security.AuthenticationContext;

/**
 * The Security Service for handling authentication details
 */
@Component
public class SecurityService {

	@Autowired
	private final AuthenticationContext authenticationContext;

	public SecurityService(AuthenticationContext authenticationContext) {
		this.authenticationContext = authenticationContext;
	}

	/**
	 * Get the currently authenticated user.
	 * 
	 * @return UserDetails of the logged-in user
	 */
	public UserDetails getAuthenticatedUser() {
		return authenticationContext.getAuthenticatedUser(UserDetails.class).orElse(null);
	}

	/**
	 * Log out the current user.
	 */
	public void logout() {
		authenticationContext.logout();
	}
}
