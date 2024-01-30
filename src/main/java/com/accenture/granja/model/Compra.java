package com.accenture.granja.model;

import java.time.LocalDate;
import java.util.ArrayList;
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



@Entity
public class Compra extends Transaccion {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String nombrePersona;
	
	@OneToMany(mappedBy = "compra", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Animal> productos = new ArrayList<Animal>();
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnore
	@JoinColumn(name = "granjaCompra_id")
	public Granja granja;
	
	
	LocalDate fecha;
	
	public Compra() {
		super();
	}
   
	public Compra(String nombrePersona, LocalDate fecha) {
		super(nombrePersona, fecha);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombrePersona() {
		return nombrePersona;
	}

	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}
/*
	public Granja getGranja() {
		return granja;
	}

	public void setGranja(Granja granja) {
		this.granja = granja;
	}
*/
	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	
	

}