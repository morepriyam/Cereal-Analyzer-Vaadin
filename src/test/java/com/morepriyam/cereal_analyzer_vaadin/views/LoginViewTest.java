package com.morepriyam.cereal_analyzer_vaadin.views;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.login.LoginForm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LoginViewTest {

	private LoginView loginView;

	@BeforeEach
	void setUp() {
		loginView = new LoginView();
	}

	@Test
	void shouldInitializeWithCorrectComponents() {
		assertThat(loginView.getChildren().filter(component -> component instanceof H1).count()).isEqualTo(1);
		assertThat(loginView.getChildren().filter(component -> component instanceof Span).count()).isEqualTo(2);
		assertThat(loginView.getChildren().filter(component -> component instanceof LoginForm).count()).isEqualTo(1);
	}

}