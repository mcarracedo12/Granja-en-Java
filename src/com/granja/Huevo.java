package com.granja;

import java.time.LocalDate;

public class Huevo extends Ganado {
	String animal = "huevo";
	static int diasExpiracion = 21;
	public LocalDate nacimiento;
	private int edadActual;
	LocalDate fechaExpiracion;

	public Huevo(int id, int edadEnDiasAlIngresar, LocalDate fechaIngresoAGranja) {
		super(id, edadEnDiasAlIngresar, fechaIngresoAGranja);
		this.nacimiento = now.minusDays(edadEnDiasAlIngresar);
		// this.edadActual = now.minusLocalDate(nacimiento);
		// this.precioVenta = Precios.getPrecioVentaByAnimal(animal); Me pide que ponga
		// el precio como Static
		this.fechaExpiracion = nacimiento.plusDays(diasExpiracion);
	}



	// public static void setDiasExpiracion(int diasExpiracion) {
	//		Huevo.diasExpiracion = diasExpiracion;
	//	}

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



}
