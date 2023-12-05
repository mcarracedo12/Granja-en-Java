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
	private BigDecimal total;
	private LocalDate fecha;

	public Transaccion(String nombrePersona, ArrayList<Producto> productos, BigDecimal total, LocalDate fecha) {
		super();
		//this.id = id;
		this.nombrePersona = nombrePersona;
		this.productos = productos;
		this.fecha = fecha;
	}

	//public long getId() {
		//return id;
//	}

	

	public String getNombrePersona() {
		return nombrePersona;
	}

	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		for (Producto producto : productos) {
			total = total.add(producto.getPrecio());
			// total = total.reduce(total, producto.getPrecio());
		}
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

}