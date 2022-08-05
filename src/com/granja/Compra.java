package com.granja;

import java.time.LocalDate;
import java.util.ArrayList;

public class Compra extends Transaccion {

	public Compra(int id, String nombrePersona, ArrayList<Ganado> productos, String total, LocalDate fecha) {
		super(id, nombrePersona, productos, total, fecha);
	}

}
