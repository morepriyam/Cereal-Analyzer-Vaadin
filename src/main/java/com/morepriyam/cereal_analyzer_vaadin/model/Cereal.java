package com.morepriyam.cereal_analyzer_vaadin.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cereal")
public class Cereal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String type;
	private int calories;
	private double protein;
	private double fat;
	private double sodium;
	private double fiber;
	private double carbo;
	private double sugars;
	private double potass;
	private int vitamins;
	private int shelf;
	private double weight;
	private double cups;
	private double rating;

	@ManyToOne
	@JoinColumn(name = "manufacturer_id", nullable = false)
	@JsonBackReference
	private Manufacturer manufacturer;

	public Cereal() {
	}

	public Cereal(String name, String type, int calories, double protein, double fat, double sodium, double fiber,
			double carbo, double sugars, double potass, int vitamins, int shelf, double weight, double cups,
			double rating, Manufacturer manufacturer) {
		this.name = name;
		this.type = type;
		this.calories = calories;
		this.protein = protein;
		this.fat = fat;
		this.sodium = sodium;
		this.fiber = fiber;
		this.carbo = carbo;
		this.sugars = sugars;
		this.potass = potass;
		this.vitamins = vitamins;
		this.shelf = shelf;
		this.weight = weight;
		this.cups = cups;
		this.rating = rating;
		this.manufacturer = manufacturer;
	}
}
