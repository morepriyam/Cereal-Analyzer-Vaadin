package com.morepriyam.cereal_analyzer_vaadin.views;

import com.morepriyam.cereal_analyzer_vaadin.model.Manufacturer;
import com.morepriyam.cereal_analyzer_vaadin.service.ManufacturerService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import jakarta.annotation.security.PermitAll;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@PermitAll
@Getter
@Setter
@Route(value = "manufacturers", layout = CerealMainLayout.class)
public class ManufacturerView extends VerticalLayout implements Serializable {

	private static final long serialVersionUID = 1L;

	private final ManufacturerService manufacturerService;

	private final Grid<Manufacturer> manufacturerGrid = new Grid<>(Manufacturer.class);

	private final TextField nameField = new TextField("Name");
	private final Button addButton = new Button("Add Manufacturer");
	private final Button updateButton = new Button("Update Selected Manufacturer");
	private final Button deleteButton = new Button("Delete Selected Manufacturer");
	private final Button resetButton = new Button("Reset Grid");

	public ManufacturerView(ManufacturerService manufacturerService) {
		this.manufacturerService = manufacturerService;

		manufacturerGrid.setColumns("id", "name");
		manufacturerGrid.setItems(manufacturerService.getAllManufacturers());
		manufacturerGrid.setSelectionMode(Grid.SelectionMode.SINGLE);

		addButton.addClickListener(click -> {
			try {
				Manufacturer newManufacturer = new Manufacturer();
				newManufacturer.setName(nameField.getValue());
				Manufacturer savedManufacturer = manufacturerService.addManufacturer(newManufacturer);
				resetGrid();
				Notification.show("Manufacturer added: " + savedManufacturer.getName());
			} catch (Exception e) {
				Notification.show("Error adding manufacturer: " + e.getMessage(), 5000, Notification.Position.MIDDLE);
			}
		});

		updateButton.addClickListener(click -> {
			Manufacturer selectedManufacturer = manufacturerGrid.asSingleSelect().getValue();
			if (selectedManufacturer != null) {
				selectedManufacturer.setName(nameField.getValue());
				try {
					manufacturerService.updateManufacturer(selectedManufacturer, selectedManufacturer.getId());
					resetGrid();
					Notification.show("Manufacturer updated: " + selectedManufacturer.getName());
				} catch (Exception e) {
					Notification.show("Error updating manufacturer: " + e.getMessage(), 5000,
							Notification.Position.MIDDLE);
				}
			} else {
				Notification.show("No manufacturer selected", 3000, Notification.Position.MIDDLE);
			}
		});

		deleteButton.addClickListener(click -> {
			Manufacturer selectedManufacturer = manufacturerGrid.asSingleSelect().getValue();
			if (selectedManufacturer != null) {
				manufacturerService.deleteManufacturer(selectedManufacturer.getId());
				resetGrid();
				Notification.show("Manufacturer deleted: " + selectedManufacturer.getName());
			} else {
				Notification.show("No manufacturer selected", 3000, Notification.Position.MIDDLE);
			}
		});

		resetButton.addClickListener(click -> resetGrid());

		HorizontalLayout buttonsLayout = new HorizontalLayout(addButton, updateButton, deleteButton, resetButton);

		add(nameField, buttonsLayout, manufacturerGrid);
	}

	public void resetGrid() {
		manufacturerGrid.setItems(manufacturerService.getAllManufacturers());
	}
}
