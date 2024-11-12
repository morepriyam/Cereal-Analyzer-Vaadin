package com.morepriyam.cereal_analyzer_vaadin.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CerealAndManufacturerTest {

	@Test
	void cerealShouldSetAndGetFieldsCorrectly() {
		Manufacturer manufacturer = new Manufacturer(1L, "Test Manufacturer");
		Cereal cereal = new Cereal("Test Cereal", "C", 100, 5.0, 2.0, 150.0, 3.0, 20.0, 10.0, 50.0, 25, 1, 1.0, 0.5,
				75.5, manufacturer);

		cereal.setId(1L);

		assertThat(cereal.getId()).isEqualTo(1L);
		assertThat(cereal.getName()).isEqualTo("Test Cereal");
		assertThat(cereal.getType()).isEqualTo("C");
		assertThat(cereal.getCalories()).isEqualTo(100);
		assertThat(cereal.getProtein()).isEqualTo(5.0);
		assertThat(cereal.getFat()).isEqualTo(2.0);
		assertThat(cereal.getSodium()).isEqualTo(150.0);
		assertThat(cereal.getFiber()).isEqualTo(3.0);
		assertThat(cereal.getCarbo()).isEqualTo(20.0);
		assertThat(cereal.getSugars()).isEqualTo(10.0);
		assertThat(cereal.getPotass()).isEqualTo(50.0);
		assertThat(cereal.getVitamins()).isEqualTo(25);
		assertThat(cereal.getShelf()).isEqualTo(1);
		assertThat(cereal.getWeight()).isEqualTo(1.0);
		assertThat(cereal.getCups()).isEqualTo(0.5);
		assertThat(cereal.getRating()).isEqualTo(75.5);
		assertThat(cereal.getManufacturer()).isEqualTo(manufacturer);
	}

	@Test
	void manufacturerShouldSetAndGetFieldsCorrectly() {
		Manufacturer manufacturer = new Manufacturer(1L, "Test Manufacturer");

		assertThat(manufacturer.getId()).isEqualTo(1L);
		assertThat(manufacturer.getName()).isEqualTo("Test Manufacturer");

		Cereal cereal1 = new Cereal();
		cereal1.setName("Cereal 1");
		cereal1.setManufacturer(manufacturer);

		Cereal cereal2 = new Cereal();
		cereal2.setName("Cereal 2");
		cereal2.setManufacturer(manufacturer);

		List<Cereal> cereals = Arrays.asList(cereal1, cereal2);
		manufacturer.setCereals(cereals);

		assertThat(manufacturer.getCereals()).containsExactly(cereal1, cereal2);
	}

	@Test
	void manufacturerShouldHandleNoCerealsGracefully() {
		Manufacturer manufacturer = new Manufacturer(2L, "Empty Manufacturer");

		assertThat(manufacturer.getCereals()).isNull();
	}

	@Test
	void cerealShouldHandleNoManufacturerGracefully() {
		Cereal cereal = new Cereal();
		cereal.setName("Orphan Cereal");

		assertThat(cereal.getManufacturer()).isNull();
	}
}