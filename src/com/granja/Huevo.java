package com.granja;

import java.time.LocalDate;

public class Huevo extends Ganado {
	private String animal = "huevo";
	private int diasExpiracion = 21;
	// Hay que sacarlo de la tabla de TiposAnimales
	private LocalDate nacimiento;
	public LocalDate fechaExpiracion;

	public Huevo(int id, int edadEnDiasAlIngresar, LocalDate fechaIngresoAGranja) {
		super(id, edadEnDiasAlIngresar, fechaIngresoAGranja);
		this.nacimiento = fechaIngresoAGranja.minusDays(edadEnDiasAlIngresar);
		this.fechaExpiracion = nacimiento.plusDays(diasExpiracion);
	}

	//	public int diasExpiracion(String animal) {
	// return TiposAnimales.getDiasExpiracionByAnimal(animal);
	// }

	@Override
	public LocalDate getNacimiento() {
		return nacimiento;
	}

	@Override
	public void setNacimiento(LocalDate nacimiento) {
		this.nacimiento = nacimiento;
	}

	@Override
	public String toString() {
		return (super.toString() + " " + animal + " Expira el " + fechaExpiracion + ".\n");
	}

	@Override
	public void reproducir() {
		// TODO Auto-generated method stub
		super.reproducir();
	}

}
