package com.accenture.granja.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@MappedSuperclass
public abstract class Transaccion {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nombrePersona; // Cliente / comprador segun sea la transaccion
	
	
	
/*	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnore
	@JoinColumn(name = "granja_id")
	public Granja granja;
	*/
	private LocalDate fecha;
	//private double total;
	
	public Transaccion() {
		super();
	}
	
	public Transaccion(String nombrePersona, LocalDate fecha) {
		super();
		this.nombrePersona = nombrePersona;
		this.fecha = fecha;
	}

	public String getNombrePersona() {
		return nombrePersona;
	}

	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}

	
	/*public double setTotal() {
		for (Animal producto : productos) {
			double total = 0;
			//total = total + producto.getPrecio();// Aca segun si es compra o venta es el precio que sumo
			// total = total.reduce(total, producto.getPrecio());
		}
		return total;
	}

	public double getTotal() {
		return total;
	}
*/


	public LocalDate getFecha() {
		return fecha;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
/*
	public Granja getGranja() {
		return granja;
	}

	public void setGranja(Granja granja) {
		this.granja = granja;
	}
*/
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

}