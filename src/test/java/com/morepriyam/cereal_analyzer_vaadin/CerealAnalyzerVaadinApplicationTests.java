package com.morepriyam.cereal_analyzer_vaadin;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ApplicationTest {

	@Test
	void contextLoads() {
		// This test ensures that the Spring Boot application context loads
		// successfully.
		assertThat(true).as("Application context should load without errors").isTrue();
	}

	@Test
	void mainMethodTest() {
		// This test ensures the main method runs without throwing any exceptions.
		Application.main(new String[] {});
		assertThat(true).as("Main method should run without exceptions").isTrue();
	}
}