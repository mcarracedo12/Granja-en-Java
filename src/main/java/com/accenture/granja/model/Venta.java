package com.accenture.granja.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Entity
@Data
//@DiscriminatorValue("Venta")
public class Venta extends Transaccion {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	protected String nombrePersona; // Cliente / comprador segun sea la transaccion
	
	protected LocalDate fecha;
	
	@ManyToOne(fetch = FetchType.LAZY)
	//@JsonIgnore
	@JoinColumn(name = "granja_id")
	public Granja granja;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy= "venta", orphanRemoval = true)
	//@JsonIgnore
	private List<Animal> productosVendidos;

	
	
	public Venta(Long id, String nombrePersona, LocalDate fecha) {
		super(nombrePersona, fecha);
	}

}