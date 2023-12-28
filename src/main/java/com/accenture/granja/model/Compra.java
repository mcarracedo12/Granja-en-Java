package com.accenture.granja.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.persistence.Entity;

@Entity
public class Compra extends Transaccion {

	 // Default constructor para que no me de error despues de un rato
   
	public Compra(long id, String nombrePersona, ArrayList<Producto> productos, BigDecimal total, LocalDate fecha) {
		super(nombrePersona, productos, total, fecha);
	}

}