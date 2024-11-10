package com.morepriyam.cereal_analyzer_vaadin.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "manufacturer")
public class Manufacturer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@OneToMany(mappedBy = "manufacturer")
	@JsonManagedReference
	private List<Cereal> cereals;

	public Manufacturer() {
	}

	public Manufacturer(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Manufacturer(Long id, String name, List<Cereal> cereals) {
		this.id = id;
		this.name = name;
		this.cereals = cereals;
	}
}
