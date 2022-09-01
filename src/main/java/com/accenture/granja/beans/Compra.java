package com.accenture.granja.beans;



import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Compra extends Transaccion {
	@Id
	@GeneratedValue
	private long id;
	public Compra(long id, String nombrePersona, ArrayList<Producto> productos, BigDecimal total, LocalDate fecha) {
		super(nombrePersona, productos, total, fecha);
	}

}