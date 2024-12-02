package com.morepriyam.cereal_analyzer_vaadin.service;

import com.morepriyam.cereal_analyzer_vaadin.views.Observer;

public interface Subject {
	void addObserver(Observer observer);

	void removeObserver(Observer observer);

	void notifyObservers();
}
