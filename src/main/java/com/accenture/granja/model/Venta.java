package com.accenture.granja.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.persistence.Entity;

@Entity
public class Venta extends Transaccion {

	public Venta(long id, String nombrePersona, ArrayList<Producto> productos, BigDecimal total, LocalDate fecha) {
		super(nombrePersona, productos, total, fecha);
	}

}