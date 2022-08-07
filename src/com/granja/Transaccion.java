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
		this.total = total;
		this.fecha = fecha;
	}

}
