package com.morepriyam.cereal_analyzer_vaadin.service;

import java.util.List;
import java.util.Optional;

import com.morepriyam.cereal_analyzer_vaadin.model.Cereal;

public interface CerealService extends Subject {

	/**
	 * Fetches all the cereals from the data source.
	 *
	 * @return A list of Cereal objects containing information about all cereals.
	 */
	List<Cereal> getCereals();

	/**
	 * Fetches a specific cereal by its name.
	 *
	 * @param name The name of the cereal.
	 * @return An Optional containing the Cereal object with the specified name, or
	 *         an empty Optional if not found.
	 */
	Optional<Cereal> getCereal(String name);

	/**
	 * Fetches a specific cereal by its name.
	 *
	 * @param id The id of the cereal.
	 * @return An Optional containing the Cereal object with the specified name, or
	 *         an empty Optional if not found.
	 */
	Optional<Cereal> getCerealById(Long id);

	/**
	 * Adds a new cereal to the data source.
	 *
	 * @param cereal The Cereal object containing the details of the new cereal to
	 *               add.
	 * @return The added Cereal object.
	 */
	Cereal addCereal(Cereal cereal);

	/**
	 * Updates an existing cereal in the data source.
	 *
	 * @param id     The id of the cereal to update.
	 * @param cereal The Cereal object containing updated details.
	 * @return The updated Cereal object, or an empty Optional if the cereal is not
	 *         found.
	 */
	void updateCereal(Cereal cereal, Long id);

	/**
	 * Deletes a cereal from the data source by its name.
	 *
	 * @param name The name of the cereal to delete.
	 * @return True if the cereal was successfully deleted, false otherwise.
	 */
	boolean deleteCereal(String name);

}
