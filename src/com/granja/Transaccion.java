package com.granja;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Transaccion {
	int id;
	private String nombrePersona;
	private ArrayList<Producto> productos = new ArrayList();
	private BigDecimal total;
	private LocalDate fecha;

	public Transaccion(int id, String nombrePersona, ArrayList<Producto> productos, BigDecimal total, LocalDate fecha) {
		super();
		this.id = id;
		this.nombrePersona = nombrePersona;
		this.productos = productos;
		this.fecha = fecha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
