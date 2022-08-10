package com.granja;

import java.time.LocalDate;

public abstract class Ganado {
	LocalDate now = LocalDate.now();
	private int id;
	private int edadEnDiasAlIngresar;
	private LocalDate nacimiento;
	private LocalDate ingresoAGranja;
	private String animal;
	private int diasExpiracion;
	public LocalDate fechaExpiracion;
	int tiempoDeReproduccion;
	// private int edadActual;

	public Ganado(int id, int edadEnDiasAlIngresar, LocalDate fechaIngresoAGranja) {
		this.id = id;
		this.edadEnDiasAlIngresar = edadEnDiasAlIngresar;
		this.nacimiento = fechaIngresoAGranja.minusDays(edadEnDiasAlIngresar);
		this.ingresoAGranja = fechaIngresoAGranja;
		this.fechaExpiracion = this.nacimiento.plusDays(this.getDiasExpiracion());
		// this.setEdadActual(now.compareTo(getNacimiento()));
		// Desde aca solo no me lo toma en las clases
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(LocalDate nacimiento) {
		this.nacimiento = nacimiento;
	}

	public LocalDate getIngresoAGranja() {
		return ingresoAGranja;
	}

	public void setIngresoAGranja(LocalDate ingresoAGranja) {
		this.ingresoAGranja = ingresoAGranja;
	}

	//	public void setPrecioVenta(String animal) {
	// TiposAnimales.getPrecioVenta(String animal) = precioVenta;
	// this.setPrecioVenta(animal); // hay que ver si funciona esto...
	//	}

	@Override
	public String toString() {
		return String.format("Id - %d, Fecha nacimiento - %s, Ingreso a Granja - %s, \n ", id, nacimiento,
				ingresoAGranja);
	}

	public int getDiasExpiracion() {
		return this.diasExpiracion;
	}

	public int getEdadEnDiasAlIngresar() {
		return edadEnDiasAlIngresar;
	}

	public void setEdadEnDiasAlIngresar(int edadEnDiasAlIngresar) {
		this.edadEnDiasAlIngresar = edadEnDiasAlIngresar;
	}

	public LocalDate getFechaExpiracion() {
		return fechaExpiracion;
	}

	public void setFechaExpiracion(LocalDate fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
	}

	public String getAnimal() {
		return animal;
	}

	public void setAnimal(String animal) {
		this.animal = animal;
	}

	public void reproducir() {

	}



	// public int diasExpiracion(String animal) {
	// return TiposAnimales.getDiasExpiracionByAnimal(animal);
	// }

}
