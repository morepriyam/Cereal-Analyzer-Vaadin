package com.morepriyam.cereal_analyzer_vaadin.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.morepriyam.cereal_analyzer_vaadin.model.Cereal;
import com.morepriyam.cereal_analyzer_vaadin.repository.CerealRepository;
import com.morepriyam.cereal_analyzer_vaadin.service.CerealAnalysisService;

@Service
public class CerealAnalysisServiceImpl implements CerealAnalysisService {

	private final CerealRepository repository;
	

    private static CerealAnalysisServiceImpl instance;


    public static synchronized CerealAnalysisServiceImpl getInstance(CerealRepository repository) {
        if (instance == null) {
            instance = new CerealAnalysisServiceImpl(repository);
        }
        return instance;
    }
	

	public CerealAnalysisServiceImpl(CerealRepository repository) {
		this.repository = repository;
	}
	

	@Override
	public Optional<Cereal> getMaxRatedCereal() {
		return repository.findAll().stream().max(Comparator.comparing(Cereal::getRating));
	}

	@Override
	public Optional<Cereal> getMinRatedCereal() {
		return repository.findAll().stream().min(Comparator.comparing(Cereal::getRating));
	}

	@Override
	public Optional<Cereal> getHealthiestCereal() {
		return repository.findAll().stream()
				.max(Comparator.comparing(Cereal::getProtein)
						.thenComparing(Cereal::getCalories, Comparator.reverseOrder())
						.thenComparing(Cereal::getFat, Comparator.reverseOrder()));
	}

	@Override
	public List<Cereal> getTop5HighestProteinCereals() {
		return repository.findAll().stream().sorted(Comparator.comparing(Cereal::getProtein).reversed()).limit(5)
				.collect(Collectors.toList());
	}
}
