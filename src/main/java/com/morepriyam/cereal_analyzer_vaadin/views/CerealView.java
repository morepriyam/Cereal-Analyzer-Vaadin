package com.morepriyam.cereal_analyzer_vaadin.views;

import com.morepriyam.cereal_analyzer_vaadin.model.Cereal;
import com.morepriyam.cereal_analyzer_vaadin.model.Manufacturer;
import com.morepriyam.cereal_analyzer_vaadin.repository.CerealRepository;
import com.morepriyam.cereal_analyzer_vaadin.service.CerealService;
import com.morepriyam.cereal_analyzer_vaadin.service.ManufacturerService;
import com.morepriyam.cereal_analyzer_vaadin.service.impl.CerealAnalysisServiceImpl;
import com.morepriyam.cereal_analyzer_vaadin.service.CerealAnalysisService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;

import jakarta.annotation.security.PermitAll;
import java.util.List;

@PermitAll
public class CerealView extends VerticalLayout implements Observer {

	private static final long serialVersionUID = 1L;
	private final CerealService cerealService;
	private final ManufacturerService manufacturerService;
	private final CerealAnalysisService cerealAnalysisService;

	private final Grid<Cereal> cerealGrid = new Grid<>(Cereal.class);

	private final TextField nameField = new TextField("Name *");
	private final TextField typeField = new TextField("Type (C/H) *");
	private final NumberField caloriesField = new NumberField("Calories (int) *");
	private final NumberField proteinField = new NumberField("Protein (float) *");
	private final NumberField fatField = new NumberField("Fat (float) *");
	private final NumberField sodiumField = new NumberField("Sodium (float) *");
	private final NumberField fiberField = new NumberField("Fiber (float) *");
	private final NumberField carboField = new NumberField("Carbohydrates (float) *");
	private final NumberField sugarsField = new NumberField("Sugars (float) *");
	private final NumberField potassField = new NumberField("Potassium (float) *");
	private final NumberField vitaminsField = new NumberField("Vitamins (int) *");
	private final NumberField shelfField = new NumberField("Shelf (int) *");
	private final NumberField weightField = new NumberField("Weight (float) *");
	private final NumberField cupsField = new NumberField("Cups (float) *");
	private final NumberField ratingField = new NumberField("Rating (float) *");
	private final NumberField manufacturerIdField = new NumberField("Manufacturer ID (int) *");

	private final Button addButton = new Button("Add Cereal");
	private final Button deleteButton = new Button("Delete Selected Cereal");
	private final Button maxRatedButton = new Button("Show Max Rated Cereal");

	public CerealView(CerealService cerealService, ManufacturerService manufacturerService,
			CerealRepository cerealRepository) {
		this.cerealService = cerealService;
		this.manufacturerService = manufacturerService;

		this.cerealAnalysisService = CerealAnalysisServiceImpl.getInstance(cerealRepository);

		cerealService.addObserver(this);

		cerealGrid.setColumns("id", "name", "type", "calories", "protein", "fat", "sodium");

		addButton.addClickListener(click -> addCereal());
		deleteButton.addClickListener(click -> deleteSelectedCereal());
		maxRatedButton.addClickListener(click -> showMaxRatedCereal());

		HorizontalLayout fieldsLayout = new HorizontalLayout(nameField, typeField, caloriesField, proteinField,
				fatField, sodiumField, fiberField, carboField);
		HorizontalLayout buttonsLayout = new HorizontalLayout(addButton, deleteButton, maxRatedButton);

		add(fieldsLayout, cerealGrid, buttonsLayout);
	}

	public void triggerResetGrid() {
		resetGrid();
	}

	private void resetGrid() {
		cerealGrid.setItems(cerealService.getCereals());
	}

	private void addCereal() {
		try {
			Manufacturer manufacturer = manufacturerService
					.getManufacturerById(manufacturerIdField.getValue().longValue())
					.orElseThrow(() -> new IllegalArgumentException("Manufacturer not found!"));

			Cereal newCereal = new Cereal(nameField.getValue(), typeField.getValue(),
					caloriesField.getValue().intValue(), proteinField.getValue(), fatField.getValue(),
					sodiumField.getValue(), fiberField.getValue(), carboField.getValue(), sugarsField.getValue(),
					potassField.getValue(), vitaminsField.getValue().intValue(), shelfField.getValue().intValue(),
					weightField.getValue(), cupsField.getValue(), ratingField.getValue(), manufacturer);

			cerealService.addCereal(newCereal);
			resetGrid();
			Notification.show("Cereal added successfully!", 3000, Notification.Position.MIDDLE);
		} catch (Exception e) {
			Notification.show("Error adding cereal: " + e.getMessage(), 3000, Notification.Position.MIDDLE);
		}
	}

	private void deleteSelectedCereal() {
		Cereal selectedCereal = cerealGrid.asSingleSelect().getValue();
		if (selectedCereal != null) {
			cerealService.deleteCereal(selectedCereal.getName());
			resetGrid();
			Notification.show("Cereal deleted successfully!", 3000, Notification.Position.MIDDLE);
		} else {
			Notification.show("No cereal selected for deletion.", 3000, Notification.Position.MIDDLE);
		}
	}

	private void showMaxRatedCereal() {
		cerealAnalysisService.getMaxRatedCereal().ifPresentOrElse(cereal -> cerealGrid.setItems(List.of(cereal)),
				() -> Notification.show("No cereals found.", 3000, Notification.Position.MIDDLE));
	}

	// Getter methods for test access
	public Button getAddButton() {
		return addButton;
	}

	public Button getDeleteButton() {
		return deleteButton;
	}

	public Button getMaxRatedButton() {
		return maxRatedButton;
	}

	public Grid<Cereal> getCerealGrid() {
		return cerealGrid;
	}

	public TextField getNameField() {
		return nameField;
	}

	public TextField getTypeField() {
		return typeField;
	}

	public NumberField getCaloriesField() {
		return caloriesField;
	}

	public NumberField getProteinField() {
		return proteinField;
	}

	public NumberField getFatField() {
		return fatField;
	}

	public NumberField getSodiumField() {
		return sodiumField;
	}

	public NumberField getFiberField() {
		return fiberField;
	}

	public NumberField getCarboField() {
		return carboField;
	}

	public NumberField getSugarsField() {
		return sugarsField;
	}

	public NumberField getPotassField() {
		return potassField;
	}

	public NumberField getVitaminsField() {
		return vitaminsField;
	}

	public NumberField getShelfField() {
		return shelfField;
	}

	public NumberField getWeightField() {
		return weightField;
	}
 
	public NumberField getCupsField() {
		return cupsField;
	}

	public NumberField getRatingField() {
		return ratingField;
	}

	public NumberField getManufacturerIdField() {
		return manufacturerIdField;
	}

	@Override
	public void update() {
		resetGrid(); // Refresh the grid
		Notification.show("Grid updated!", 2000, Notification.Position.MIDDLE);
	}
}
