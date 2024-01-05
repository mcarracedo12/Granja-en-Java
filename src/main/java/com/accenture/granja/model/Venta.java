package com.accenture.granja.model;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.persistence.Entity;

@Entity
public class Venta extends Transaccion {

	public Venta(String nombrePersona, ArrayList<Producto> productos, LocalDate fecha) {
		super(nombrePersona, productos, fecha);
	}

}