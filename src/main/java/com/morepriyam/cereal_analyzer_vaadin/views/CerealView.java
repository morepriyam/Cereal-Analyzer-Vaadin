package com.morepriyam.cereal_analyzer_vaadin.views;

import com.morepriyam.cereal_analyzer_vaadin.model.Cereal;
import com.morepriyam.cereal_analyzer_vaadin.model.Manufacturer;
import com.morepriyam.cereal_analyzer_vaadin.service.CerealService;
import com.morepriyam.cereal_analyzer_vaadin.service.ManufacturerService;
import com.morepriyam.cereal_analyzer_vaadin.service.CerealAnalysisService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import jakarta.annotation.security.PermitAll;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@PermitAll
@Route(value = "cereals", layout = CerealMainLayout.class)
public class CerealView extends VerticalLayout implements Serializable {

	private static final long serialVersionUID = 1L;

	private final CerealService cerealService;
	private final ManufacturerService manufacturerService;
	private final CerealAnalysisService cerealAnalysisService;

	private final Grid<Cereal> cerealGrid = new Grid<>(Cereal.class);

	private final TextField nameField = new TextField("Name *");
	private final TextField typeField = new TextField("Type (C/H) *"); // 'C' for cold, 'H' for hot
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
	private final Button updateButton = new Button("Update Selected Cereal");
	private final Button deleteButton = new Button("Delete Selected Cereal");

	private final Button maxRatedButton = new Button("Show Max Rated Cereal");
	private final Button minRatedButton = new Button("Show Min Rated Cereal");
	private final Button healthiestButton = new Button("Show Healthiest Cereal");
	private final Button top5ProteinButton = new Button("Show Top 5 High Protein Cereals");

	private final Button resetButton = new Button("Reset Grid");

	public CerealView(CerealService cerealService, ManufacturerService manufacturerService,
			CerealAnalysisService cerealAnalysisService) {
		this.cerealService = cerealService;
		this.manufacturerService = manufacturerService;
		this.cerealAnalysisService = cerealAnalysisService;

		cerealGrid.setColumns("id", "name", "type", "calories", "protein", "fat", "sodium", "fiber", "carbo", "sugars",
				"potass", "vitamins", "shelf", "weight", "cups", "rating", "manufacturer.name");
		cerealGrid.getColumnByKey("manufacturer.name").setHeader("Manufacturer");
		cerealGrid.setSelectionMode(Grid.SelectionMode.SINGLE);

		resetGrid();

		HorizontalLayout row1 = new HorizontalLayout(nameField, typeField, caloriesField, proteinField, fatField,
				sodiumField, fiberField, carboField);
		HorizontalLayout row2 = new HorizontalLayout(sugarsField, potassField, vitaminsField, shelfField, weightField,
				cupsField, ratingField, manufacturerIdField);

		addButton.addClickListener(click -> {
			if (areFieldsValid()) {
				addCereal();
			}
		});

		updateButton.addClickListener(click -> {
			if (areFieldsValid()) {
				updateSelectedCereal();
			}
		});

		deleteButton.addClickListener(click -> deleteSelectedCereal());
		resetButton.addClickListener(click -> resetGrid());

		maxRatedButton.addClickListener(click -> showMaxRatedCereal());
		minRatedButton.addClickListener(click -> showMinRatedCereal());
		healthiestButton.addClickListener(click -> showHealthiestCereal());
		top5ProteinButton.addClickListener(click -> showTop5HighProteinCereals());

		HorizontalLayout actionButtonsLayout = new HorizontalLayout(addButton, updateButton, deleteButton);
		HorizontalLayout analysisButtonsLayout = new HorizontalLayout(maxRatedButton, minRatedButton, healthiestButton,
				top5ProteinButton, resetButton);

		add(row1, row2, actionButtonsLayout, analysisButtonsLayout, cerealGrid);
	}

	public void triggerResetGrid() {
		resetGrid();
	}

	private boolean areFieldsValid() {
		if (nameField.isEmpty() || typeField.isEmpty() || caloriesField.isEmpty() || proteinField.isEmpty()
				|| fatField.isEmpty() || sodiumField.isEmpty() || fiberField.isEmpty() || carboField.isEmpty()
				|| sugarsField.isEmpty() || potassField.isEmpty() || vitaminsField.isEmpty() || shelfField.isEmpty()
				|| weightField.isEmpty() || cupsField.isEmpty() || ratingField.isEmpty()
				|| manufacturerIdField.isEmpty()) {
			Notification.show("All fields are required!", 3000, Notification.Position.MIDDLE);
			return false;
		}
		return true;
	}

	private void addCereal() {
		try {
			Cereal newCereal = createCerealFromFields();

			Manufacturer manufacturer = ensureManufacturerExistsById(newCereal.getManufacturer());
			newCereal.setManufacturer(manufacturer);

			Cereal savedCereal = cerealService.addCereal(newCereal);
			resetGrid();
			Notification.show("Cereal added: " + savedCereal.getName());
		} catch (Exception e) {
			Notification.show("Error adding cereal: " + e.getMessage(), 5000, Notification.Position.MIDDLE);
		}
	}

	private void updateSelectedCereal() {
		Cereal selectedCereal = cerealGrid.asSingleSelect().getValue();
		if (selectedCereal != null) {
			try {
				Cereal updatedCereal = createCerealFromFields();

				Manufacturer manufacturer = ensureManufacturerExistsById(updatedCereal.getManufacturer());
				updatedCereal.setManufacturer(manufacturer);

				cerealService.updateCereal(updatedCereal, selectedCereal.getId());
				resetGrid();
				Notification.show("Cereal updated: " + updatedCereal.getName());
			} catch (Exception e) {
				Notification.show("Error updating cereal: " + e.getMessage(), 5000, Notification.Position.MIDDLE);
			}
		} else {
			Notification.show("No cereal selected", 3000, Notification.Position.MIDDLE);
		}
	}

	private void deleteSelectedCereal() {
		Cereal selectedCereal = cerealGrid.asSingleSelect().getValue();
		if (selectedCereal != null) {
			cerealService.deleteCereal(selectedCereal.getName());
			resetGrid();
			Notification.show("Cereal deleted: " + selectedCereal.getName());
		} else {
			Notification.show("No cereal selected", 3000, Notification.Position.MIDDLE);
		}
	}

	private void showMaxRatedCereal() {
		cerealAnalysisService.getMaxRatedCereal().ifPresentOrElse(cereal -> cerealGrid.setItems(List.of(cereal)),
				() -> Notification.show("No cereals found", 3000, Notification.Position.MIDDLE));
	}

	private void showMinRatedCereal() {
		cerealAnalysisService.getMinRatedCereal().ifPresentOrElse(cereal -> cerealGrid.setItems(List.of(cereal)),
				() -> Notification.show("No cereals found", 3000, Notification.Position.MIDDLE));
	}

	private void showHealthiestCereal() {
		cerealAnalysisService.getHealthiestCereal().ifPresentOrElse(cereal -> cerealGrid.setItems(List.of(cereal)),
				() -> Notification.show("No cereals found", 3000, Notification.Position.MIDDLE));
	}

	private void showTop5HighProteinCereals() {
		List<Cereal> top5Cereals = cerealAnalysisService.getTop5HighestProteinCereals();
		if (!top5Cereals.isEmpty()) {
			cerealGrid.setItems(top5Cereals);
		} else {
			Notification.show("No cereals found", 3000, Notification.Position.MIDDLE);
		}
	}

	private void resetGrid() {
		cerealGrid.setItems(cerealService.getCereals());
	}

	private Manufacturer ensureManufacturerExistsById(Manufacturer manufacturer) {
		return manufacturerService.getManufacturerById(manufacturer.getId())
				.orElseThrow(() -> new IllegalArgumentException("Manufacturer ID not found."));
	}

	private Cereal createCerealFromFields() {
		Cereal cereal = new Cereal();
		cereal.setName(nameField.getValue());
		cereal.setType(typeField.getValue());
		cereal.setCalories(caloriesField.getValue().intValue());
		cereal.setProtein(proteinField.getValue());
		cereal.setFat(fatField.getValue());
		cereal.setSodium(sodiumField.getValue());
		cereal.setFiber(fiberField.getValue());
		cereal.setCarbo(carboField.getValue());
		cereal.setSugars(sugarsField.getValue());
		cereal.setPotass(potassField.getValue());
		cereal.setVitamins(vitaminsField.getValue().intValue());
		cereal.setShelf(shelfField.getValue().intValue());
		cereal.setWeight(weightField.getValue());
		cereal.setCups(cupsField.getValue());
		cereal.setRating(ratingField.getValue());

		Manufacturer manufacturer = new Manufacturer();
		manufacturer.setId(manufacturerIdField.getValue().longValue());
		cereal.setManufacturer(manufacturer);

		return cereal;
	}
}
