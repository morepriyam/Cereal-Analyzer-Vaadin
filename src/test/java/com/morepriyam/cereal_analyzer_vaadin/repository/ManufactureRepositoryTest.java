package com.morepriyam.cereal_analyzer_vaadin.repository;

import com.morepriyam.cereal_analyzer_vaadin.model.Manufacturer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Sql(scripts = "/data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
class ManufacturerRepositoryTest {

	@Autowired
	private ManufacturerRepository manufacturerRepository;

	@Test
	void testFindByName() {
		Optional<Manufacturer> manufacturer = manufacturerRepository.findByName("N");
		assertThat(manufacturer).as("Manufacturer 'N' should be present in the database").isPresent();

		assertThat(manufacturer.get().getName()).as("Manufacturer name should be 'N'").isEqualTo("N");
	}

	@Test
	void testFindByNameNotFound() {
		Optional<Manufacturer> manufacturer = manufacturerRepository.findByName("NonExistentManufacturer");
		assertThat(manufacturer).as("Manufacturer 'NonExistentManufacturer' should not be present in the database")
				.isNotPresent();
	}
}