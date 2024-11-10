package com.morepriyam.cereal_analyzer_vaadin.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.morepriyam.cereal_analyzer_vaadin.model.Manufacturer;
import com.morepriyam.cereal_analyzer_vaadin.repository.ManufacturerRepository;
import com.morepriyam.cereal_analyzer_vaadin.service.ManufacturerService;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

	private final ManufacturerRepository repository;

	public ManufacturerServiceImpl(ManufacturerRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Manufacturer> getAllManufacturers() {
		return repository.findAll();
	}

	@Override
	public Optional<Manufacturer> getManufacturerById(Long id) {
		return repository.findById(id);
	}

	@Override
	public Optional<Manufacturer> getManufacturerByName(String name) {
		return repository.findByName(name);
	}

	@Override
	public Manufacturer addManufacturer(Manufacturer manufacturer) {
		if (repository.findByName(manufacturer.getName()).isPresent()) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, "Manufacturer with the same name already exists");
		}
		return repository.save(manufacturer);
	}

	@Override
	public Manufacturer updateManufacturer(Manufacturer manufacturer, Long id) {
		if (!repository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Manufacturer not found");
		}
		manufacturer.setId(id);
		return repository.save(manufacturer);
	}

	@Override
	public void deleteManufacturer(Long id) {
		if (!repository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Manufacturer not found");
		}
		repository.deleteById(id);
	}
}
