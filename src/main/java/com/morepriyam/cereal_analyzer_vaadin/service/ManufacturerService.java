package com.morepriyam.cereal_analyzer_vaadin.service;

import java.util.List;
import java.util.Optional;

import com.morepriyam.cereal_analyzer_vaadin.model.Manufacturer;

public interface ManufacturerService {
	/**
	 * Retrieves all manufacturers.
	 * 
	 * @return a list of all manufacturers.
	 */
	List<Manufacturer> getAllManufacturers();

	/**
	 * Retrieves a manufacturer by its unique ID.
	 * 
	 * @param id the ID of the manufacturer to retrieve.
	 * @return an Optional containing the manufacturer if found, or an empty
	 *         Optional if not.
	 */
	Optional<Manufacturer> getManufacturerById(Long id);

	/**
	 * Retrieves a manufacturer by its name.
	 * 
	 * @param name the name of the manufacturer to retrieve.
	 * @return an Optional containing the manufacturer if found, or an empty
	 *         Optional if not.
	 */
	Optional<Manufacturer> getManufacturerByName(String name);

	/**
	 * Adds a new manufacturer to the system.
	 * 
	 * @param manufacturer the manufacturer object to add.
	 * @return the added manufacturer object.
	 */
	Manufacturer addManufacturer(Manufacturer manufacturer);

	/**
	 * Updates an existing manufacturer by its ID.
	 * 
	 * @param id           the ID of the manufacturer to update.
	 * @param manufacturer the updated manufacturer object.
	 * @return the updated manufacturer object.
	 */
	Manufacturer updateManufacturer(Manufacturer manufacturer, Long id);

	/**
	 * Deletes a manufacturer by its unique ID.
	 * 
	 * @param id the ID of the manufacturer to delete.
	 */
	void deleteManufacturer(Long id);

}
