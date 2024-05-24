package com.accenture.granja.model;

import java.time.LocalDate;

import javax.persistence.MappedSuperclass;




@MappedSuperclass
public abstract class Transaccion {

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