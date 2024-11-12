package com.morepriyam.cereal_analyzer_vaadin.repository;

import com.morepriyam.cereal_analyzer_vaadin.model.Cereal;
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
class CerealRepositoryTest {

	@Autowired
	private CerealRepository cerealRepository;

	@Test
	void testFindByName() {

		Optional<Cereal> cereal = cerealRepository.findByName("Clusters");
		assertThat(cereal).as("Cereal 'Clusters' should be present in the database").isPresent();

		assertThat(cereal.get().getCalories()).as("Calories for 'Clusters' should be 110").isEqualTo(110);
	}

	@Test
	void testFindByNameNotFound() {
		Optional<Cereal> cereal = cerealRepository.findByName("NonExistentCereal");
		assertThat(cereal).as("Cereal 'NonExistentCereal' should not be present in the database").isNotPresent();
	}
}