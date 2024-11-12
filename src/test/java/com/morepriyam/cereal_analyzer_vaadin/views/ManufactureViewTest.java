package com.morepriyam.cereal_analyzer_vaadin.views;

import com.morepriyam.cereal_analyzer_vaadin.model.Manufacturer;
import com.morepriyam.cereal_analyzer_vaadin.service.ManufacturerService;
import com.vaadin.flow.component.notification.Notification;

import com.vaadin.testbench.unit.internal.MockVaadin;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

import java.util.List;

class ManufacturerViewTest {

	private ManufacturerService manufacturerService;
	private ManufacturerView manufacturerView;

	@BeforeEach
	void setUp() {

		MockVaadin.setup();

		manufacturerService = mock(ManufacturerService.class);
		manufacturerView = new ManufacturerView(manufacturerService);
	}

	@Test
	void shouldDeleteManufacturer() {
		Manufacturer manufacturer = new Manufacturer(1L, "ToDelete");
		when(manufacturerService.getAllManufacturers()).thenReturn(List.of(manufacturer));

		manufacturerView.getManufacturerGrid().select(manufacturer);
		manufacturerView.getDeleteButton().click();

		verify(manufacturerService).deleteManufacturer(1L);
		Notification.show("Manufacturer deleted: ToDelete");
	}

	@Test
	void shouldUpdateManufacturer() {
		Manufacturer manufacturer = new Manufacturer(1L, "ToUpdate");
		when(manufacturerService.getAllManufacturers()).thenReturn(List.of(manufacturer));

		manufacturerView.getManufacturerGrid().select(manufacturer);
		manufacturerView.getNameField().setValue("Updated Manufacturer");
		manufacturerView.getUpdateButton().click();

		verify(manufacturerService).updateManufacturer(any(), eq(1L));
		Notification.show("Manufacturer updated: Updated Manufacturer");
	}
}