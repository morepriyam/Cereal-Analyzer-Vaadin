package com.morepriyam.cereal_analyzer_vaadin.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.morepriyam.cereal_analyzer_vaadin.views.LoginView;
import com.vaadin.flow.spring.security.VaadinWebSecurity;

@EnableWebSecurity
@Configuration

public class SecurityConfig extends VaadinWebSecurity {

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests(auth -> auth
				.requestMatchers(AntPathRequestMatcher.antMatcher(HttpMethod.GET, "/images/*.png")).permitAll());

		super.configure(http);
		setLoginView(http, LoginView.class);
	}

	/**
	 * Create in-memory users for basic authentication. You can replace this with a
	 * database or another user management system later.
	 */
	@Bean
	public UserDetailsService users() {
		UserDetails user = User.builder().username("user").password("{noop}userpass").roles("USER").build();
		UserDetails admin = User.builder().username("admin").password("{noop}adminpass").roles("USER", "ADMIN").build();
		return new InMemoryUserDetailsManager(user, admin);
	}
}
