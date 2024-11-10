package com.morepriyam.cereal_analyzer_vaadin.repository;

import java.util.Optional;

import org.springframework.data.repository.ListCrudRepository;

import com.morepriyam.cereal_analyzer_vaadin.model.Manufacturer;

public interface ManufacturerRepository extends ListCrudRepository<Manufacturer, Long> {

	Optional<Manufacturer> findByName(String name);

}
