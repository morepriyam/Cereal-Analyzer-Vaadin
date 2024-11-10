package com.morepriyam.cereal_analyzer_vaadin.service;

import java.util.List;
import java.util.Optional;

import com.morepriyam.cereal_analyzer_vaadin.model.Cereal;

public interface CerealAnalysisService {

	/**
	 * Finds the cereal with the highest rating.
	 *
	 * @return An Optional containing the Cereal object with the highest rating, or
	 *         an empty Optional if no cereals exist.
	 */
	Optional<Cereal> getMaxRatedCereal();

	/**
	 * Finds the cereal with the lowest rating.
	 *
	 * @return An Optional containing the Cereal object with the lowest rating, or
	 *         an empty Optional if no cereals exist.
	 */
	Optional<Cereal> getMinRatedCereal();

	/**
	 * Finds the healthiest cereal based on a balance of protein, calories, and fat.
	 *
	 * @return An Optional containing the Cereal object representing the healthiest
	 *         cereal, or an empty Optional if no cereals exist.
	 */
	Optional<Cereal> getHealthiestCereal();

	/**
	 * Finds the top 5 cereals with the highest protein content.
	 * 
	 * @return A list of the top 5 cereals with the highest protein content.
	 */
	List<Cereal> getTop5HighestProteinCereals();

}
