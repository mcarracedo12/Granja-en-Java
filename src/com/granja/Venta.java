package com.granja;

import java.time.LocalDate;
import java.util.ArrayList;

public class Venta extends Transaccion {

	public Venta(int id, String nombrePersona, ArrayList<Ganado> productos, String total, LocalDate fecha) {
		super(id, nombrePersona, productos, total, fecha);
	}

}
