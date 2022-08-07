package com.granja;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

public class Compra extends Transaccion {

	public Compra(int id, String nombrePersona, ArrayList<Producto> productos, BigDecimal total, LocalDate fecha) {
		super(id, nombrePersona, productos, total, fecha);
	}

}
