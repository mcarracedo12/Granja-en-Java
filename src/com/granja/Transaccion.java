package com.granja;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Transaccion {
	int id;
	String nombrePersona;
	ArrayList<Ganado> productos;
	BigDecimal total;
	LocalDate fecha;

	public Transaccion(int id, String nombrePersona, ArrayList<Ganado> productos, String total, LocalDate fecha) {
		super();
		this.id = id;
		this.nombrePersona = nombrePersona;
		this.productos = productos;
		this.total = new BigDecimal(total);
		this.fecha = fecha;
	}

}
