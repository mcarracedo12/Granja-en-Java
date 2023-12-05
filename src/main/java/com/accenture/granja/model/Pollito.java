package com.accenture.granja.model;



import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Pollito extends Ganado {
	@Id
	@GeneratedValue
	private long id;
	private static String animal = "pollito";
	private int diasExpiracion = 2000;
	// private int diasExpiracion;
	public LocalDate fechaExpiracion;
	private LocalDate nacimiento;
	int tiempoDeReproduccion = 1;
	// private int edadActual;

	public Pollito(long id, int edadEnDiasAlIngresar, LocalDate fechaIngresoAGranja) {
		super(id, edadEnDiasAlIngresar, fechaIngresoAGranja);
		this.nacimiento = fechaIngresoAGranja.minusDays(edadEnDiasAlIngresar);
		// this.animal = animal;
		this.fechaExpiracion = nacimiento.plusDays(diasExpiracion);
		// this.edadActual = now.compareTo(getNacimiento());
	}

	@Override
	public String toString() {
		return (super.toString() + " " + id +  " " + animal + " Expira el " + fechaExpiracion + ".\n");
	}

	@Override
	public void reproducir(LocalDate i) {
		if (i.isBefore(now)) {
			new Huevo(0, 0, i);
			System.out.println("Huevo creado con fecha de nacimiento " + i);
			//i = i.plusDays(tiempoDeReproduccion);
		}
		super.reproducir(i);
	}
	
}