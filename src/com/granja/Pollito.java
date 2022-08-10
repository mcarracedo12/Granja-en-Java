package com.granja;

import java.time.LocalDate;

public class Pollito extends Ganado {
	private static String animal = "pollito";
	private int diasExpiracion = 2000;
	// private int diasExpiracion;
	public LocalDate fechaExpiracion;
	private LocalDate nacimiento;
	int tiempoDeReproduccion = 1;
	// private int edadActual;

	public Pollito(int id, int edadEnDiasAlIngresar, LocalDate fechaIngresoAGranja) {
		super(id, edadEnDiasAlIngresar, fechaIngresoAGranja);
		this.nacimiento = fechaIngresoAGranja.minusDays(edadEnDiasAlIngresar);
		// this.animal = animal;
		this.fechaExpiracion = nacimiento.plusDays(diasExpiracion);
		// this.edadActual = now.compareTo(getNacimiento());
	}

	@Override
	public String toString() {
		return (super.toString() + " " + animal + " Expira el " + fechaExpiracion + ".\n");
	}

}
