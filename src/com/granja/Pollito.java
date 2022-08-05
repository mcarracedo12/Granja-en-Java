package com.granja;

import java.time.LocalDate;

public class Pollito extends Ganado {
	static String animal = "pollito";
	public static int diasExpiracion = 2000;
	LocalDate fechaExpiracion;
	public LocalDate nacimiento;

	public Pollito(int id, int edadEnDias, LocalDate ingresoAGranja) {
		super(id, edadEnDias, ingresoAGranja);
		this.nacimiento = now.minusDays(edadEnDias);

		// this.animal = animal;
		this.fechaExpiracion = nacimiento.plusDays(diasExpiracion);



	}

	@Override
	public String toString() {
		return (super.toString() + " " + animal + " Expira el " + fechaExpiracion + ".");
	}

}
