package com.accenture.granja.beans;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.persistence.Entity;

@Entity
public class Compra extends Transaccion {

	public Compra(long id, String nombrePersona, ArrayList<Producto> productos, BigDecimal total, LocalDate fecha) {
		super(nombrePersona, productos, total, fecha);
	}

}