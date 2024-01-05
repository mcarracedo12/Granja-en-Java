package com.accenture.granja.model;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Transaccion {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nombrePersona;
	private ArrayList<Producto> productos = new ArrayList<>();
	private LocalDate fecha;
	private double total;
	
	public Transaccion(String nombrePersona, ArrayList<Producto> productos, LocalDate fecha) {
		super();
		this.nombrePersona = nombrePersona;
		this.productos = productos;
		this.fecha = fecha;
		this.total=setTotal();
	}

	public String getNombrePersona() {
		return nombrePersona;
	}

	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public double setTotal() {
		for (Producto producto : productos) {
			total = total +producto.getPrecio();
			// total = total.reduce(total, producto.getPrecio());
		}
		return total;
	}

	public double getTotal() {
		return total;
	}



	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

}