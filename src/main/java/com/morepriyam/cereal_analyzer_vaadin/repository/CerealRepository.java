package com.morepriyam.cereal_analyzer_vaadin.repository;

import java.util.Optional;

import org.springframework.data.repository.ListCrudRepository;

import com.morepriyam.cereal_analyzer_vaadin.model.Cereal;

public interface CerealRepository extends ListCrudRepository<Cereal, Long> {

	public Optional<Cereal> findByName(String name);

}
