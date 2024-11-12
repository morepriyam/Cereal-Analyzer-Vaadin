package com.morepriyam.cereal_analyzer_vaadin.service.impl;

import com.morepriyam.cereal_analyzer_vaadin.model.Cereal;
import com.morepriyam.cereal_analyzer_vaadin.model.Manufacturer;
import com.morepriyam.cereal_analyzer_vaadin.repository.CerealRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class CerealAnalysisServiceImplTest {

	private CerealRepository cerealRepository;
	private CerealAnalysisServiceImpl cerealAnalysisService;

	@BeforeEach
	void setUp() {
		cerealRepository = mock(CerealRepository.class);
		cerealAnalysisService = new CerealAnalysisServiceImpl(cerealRepository);

		Manufacturer manufacturer1 = new Manufacturer();
		manufacturer1.setId(1L);
		manufacturer1.setName("N");

		Manufacturer manufacturer4 = new Manufacturer();
		manufacturer4.setId(4L);
		manufacturer4.setName("R");

		Manufacturer manufacturer5 = new Manufacturer();
		manufacturer5.setId(5L);
		manufacturer5.setName("G");

		List<Cereal> cereals = Arrays.asList(
				new Cereal("100% Bran", "C", 70, 4.0, 1.0, 130.0, 10.0, 5.0, 6.0, 280.0, 25, 3, 1.00, 0.33, 68.402973,
						manufacturer1),
				new Cereal("Almond Delight", "C", 110, 2.0, 2.0, 200.0, 1.0, 14.0, 8.0, 30.0, 25, 3, 1.00, 0.75,
						34.384843, manufacturer4),
				new Cereal("Clusters", "C", 110, 3.0, 2.0, 140.0, 2.0, 13.0, 7.0, 105.0, 25, 3, 1.00, 0.50, 40.400208,
						manufacturer5));

		when(cerealRepository.findAll()).thenReturn(cereals);
	}

	@Test
	void shouldReturnMaxRatedCereal() {
		Optional<Cereal> maxRatedCereal = cerealAnalysisService.getMaxRatedCereal();
		assertThat(maxRatedCereal).isPresent();
		assertThat(maxRatedCereal.get().getName()).isEqualTo("100% Bran");
		assertThat(maxRatedCereal.get().getRating()).isEqualTo(68.402973);
	}

	@Test
	void shouldReturnMinRatedCereal() {
		Optional<Cereal> minRatedCereal = cerealAnalysisService.getMinRatedCereal();
		assertThat(minRatedCereal).isPresent();
		assertThat(minRatedCereal.get().getName()).isEqualTo("Almond Delight");
		assertThat(minRatedCereal.get().getRating()).isEqualTo(34.384843);
	}

	@Test
	void shouldReturnHealthiestCereal() {
		Optional<Cereal> healthiestCereal = cerealAnalysisService.getHealthiestCereal();
		assertThat(healthiestCereal).isPresent();
		assertThat(healthiestCereal.get().getName()).isEqualTo("100% Bran");
		assertThat(healthiestCereal.get().getProtein()).isEqualTo(4.0);
	}

	@Test
	void shouldReturnTop5HighestProteinCereals() {
		List<Cereal> top5ProteinCereals = cerealAnalysisService.getTop5HighestProteinCereals();
		assertThat(top5ProteinCereals).hasSize(3); // We only have 3 cereals in the dummy data.
		assertThat(top5ProteinCereals.get(0).getName()).isEqualTo("100% Bran");
		assertThat(top5ProteinCereals.get(1).getName()).isEqualTo("Clusters");
		assertThat(top5ProteinCereals.get(2).getName()).isEqualTo("Almond Delight");
	}

	@Test
	void shouldHandleEmptyRepositoryGracefully() {
		when(cerealRepository.findAll()).thenReturn(List.of());

		assertThat(cerealAnalysisService.getMaxRatedCereal()).isNotPresent();
		assertThat(cerealAnalysisService.getMinRatedCereal()).isNotPresent();
		assertThat(cerealAnalysisService.getHealthiestCereal()).isNotPresent();
		assertThat(cerealAnalysisService.getTop5HighestProteinCereals()).isEmpty();
	}
}