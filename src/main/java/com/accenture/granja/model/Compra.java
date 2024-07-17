package com.accenture.granja.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;



@Entity
@Getter
@Setter
public class Compra extends Transaccion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	protected String nombrePersona;
	
	protected LocalDate fecha;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "granja_id")
	public Granja granja;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "compra", orphanRemoval = true)
	//@JsonIgnore
	private List<Animal> productosComprados;
	
	public Compra(Long id, String nombrePersona, LocalDate fecha) {
		super(nombrePersona, fecha);
	}
	public Compra() {
		super();
	}



}