package com.morepriyam.cereal_analyzer_vaadin.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.morepriyam.cereal_analyzer_vaadin.model.Cereal;
import com.morepriyam.cereal_analyzer_vaadin.repository.CerealRepository;
import com.morepriyam.cereal_analyzer_vaadin.service.CerealService;

@Service
public class CerealServiceImpl implements CerealService {

	private final CerealRepository repository;

	public CerealServiceImpl(CerealRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Cereal> getCereals() {
		return repository.findAll();
	}

	@Override
	public Optional<Cereal> getCereal(String name) {
		return repository.findByName(name);
	}

	@Override
	public Optional<Cereal> getCerealById(Long id) {
		return repository.findById(id);
	}

	@Override
	public Cereal addCereal(Cereal cereal) {
		return repository.save(cereal);
	}

	@Override
	public void updateCereal(Cereal cereal, Long id) {
		if (!repository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cereal not found");
		}
		cereal.setId(id);
		repository.save(cereal);
	}

	@Override
	public boolean deleteCereal(String name) {
		return repository.findByName(name).map(cereal -> {
			repository.delete(cereal);
			return true;
		}).orElse(false);
	}
}
