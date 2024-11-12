package com.morepriyam.cereal_analyzer_vaadin.views;

import com.morepriyam.cereal_analyzer_vaadin.model.Cereal;
import com.morepriyam.cereal_analyzer_vaadin.model.Manufacturer;
import com.morepriyam.cereal_analyzer_vaadin.service.CerealService;
import com.morepriyam.cereal_analyzer_vaadin.service.ManufacturerService;
import com.morepriyam.cereal_analyzer_vaadin.service.CerealAnalysisService;
import com.vaadin.flow.component.grid.Grid;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CerealViewTest {

	private CerealService cerealService;
	private ManufacturerService manufacturerService;
	private CerealAnalysisService cerealAnalysisService;
	private CerealView cerealView;

	@BeforeEach
	void setUp() {
		cerealService = mock(CerealService.class);
		manufacturerService = mock(ManufacturerService.class);
		cerealAnalysisService = mock(CerealAnalysisService.class);

		cerealView = new CerealView(cerealService, manufacturerService, cerealAnalysisService);
	}

	@Test
	void shouldInitializeWithCerealsInGrid() {
		Cereal cereal = new Cereal("Test Cereal", "C", 100, 5.0, 2.0, 150.0, 3.0, 20.0, 10.0, 50.0, 25, 1, 1.0, 0.5,
				75.5, new Manufacturer());
		when(cerealService.getCereals()).thenReturn(List.of(cereal));

		cerealView.triggerResetGrid();

		Grid<Cereal> grid = cerealView.getCerealGrid();
		assertThat(grid.getGenericDataView().getItems().iterator().next()).isEqualTo(cereal);
	}

	@Test
	void shouldAddCerealWhenFieldsAreValid() {
		when(manufacturerService.getManufacturerById(anyLong()))
				.thenReturn(Optional.of(new Manufacturer(1L, "Test Manufacturer")));
		when(cerealService.addCereal(any())).thenReturn(new Cereal("Added Cereal", "C", 100, 5.0, 2.0, 150.0, 3.0, 20.0,
				10.0, 50.0, 25, 1, 1.0, 0.5, 75.5, new Manufacturer()));

		fillFields();
		cerealView.getAddButton().click();

		verify(cerealService).addCereal(any());
	}

	@Test
	void shouldShowErrorNotificationIfFieldsAreInvalidOnAdd() {
		cerealView.getAddButton().click();

		verify(cerealService, never()).addCereal(any());
	}

	@Test
	void shouldUpdateSelectedCereal() {
		Manufacturer testManufacturer = new Manufacturer(1L, "Test Manufacturer");
		Cereal selectedCereal = new Cereal("Update Cereal", "C", 100, 5.0, 2.0, 150.0, 3.0, 20.0, 10.0, 50.0, 25, 1,
				1.0, 0.5, 75.5, testManufacturer);

		when(manufacturerService.getManufacturerById(anyLong())).thenReturn(Optional.of(testManufacturer));
		cerealView.getCerealGrid().setItems(selectedCereal);
		cerealView.getCerealGrid().select(selectedCereal);

		fillFields();
		cerealView.getUpdateButton().click();

		verify(cerealService).updateCereal(argThat(cereal -> cereal.getName().equals("Test Cereal")),
				eq(selectedCereal.getId()));
	}

	@Test
	void shouldDeleteSelectedCereal() {
		Cereal selectedCereal = new Cereal("Delete Cereal", "C", 100, 5.0, 2.0, 150.0, 3.0, 20.0, 10.0, 50.0, 25, 1,
				1.0, 0.5, 75.5, new Manufacturer());
		cerealView.getCerealGrid().setItems(selectedCereal);
		cerealView.getCerealGrid().select(selectedCereal);

		cerealView.getDeleteButton().click();

		verify(cerealService).deleteCereal(selectedCereal.getName());
	}

	@Test
	void shouldShowMaxRatedCereal() {
		when(cerealAnalysisService.getMaxRatedCereal()).thenReturn(Optional.of(new Cereal("Max Rated", "C", 200, 5.0,
				3.0, 150.0, 3.0, 20.0, 10.0, 50.0, 25, 1, 1.0, 0.5, 100.0, new Manufacturer())));

		cerealView.getMaxRatedButton().click();

		assertThat(cerealView.getCerealGrid().getGenericDataView().getItems().count()).isEqualTo(1);
	}

	private void fillFields() {
		cerealView.getNameField().setValue("Test Cereal");
		cerealView.getTypeField().setValue("C");
		cerealView.getCaloriesField().setValue(100.0);
		cerealView.getProteinField().setValue(5.0);
		cerealView.getFatField().setValue(2.0);
		cerealView.getSodiumField().setValue(150.0);
		cerealView.getFiberField().setValue(3.0);
		cerealView.getCarboField().setValue(20.0);
		cerealView.getSugarsField().setValue(10.0);
		cerealView.getPotassField().setValue(50.0);
		cerealView.getVitaminsField().setValue(25.0);
		cerealView.getShelfField().setValue(1.0);
		cerealView.getWeightField().setValue(1.0);
		cerealView.getCupsField().setValue(0.5);
		cerealView.getRatingField().setValue(75.5);
		cerealView.getManufacturerIdField().setValue(1.0);
	}
}