package com.accenture.granja.beans;



import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Huevo extends Ganado {
	@Id
	@GeneratedValue
	private long id;

	private String animal = "huevo";
	private int diasExpiracion = 21;
	// Hay que sacarlo de la tabla de TiposAnimales
	private LocalDate nacimiento;
	public LocalDate fechaExpiracion;
	int tiempoDeReproduccion = 21;
	// private int edadActual;

	public Huevo(long id, int edadEnDiasAlIngresar, LocalDate fechaIngresoAGranja) {
		super(id, edadEnDiasAlIngresar, fechaIngresoAGranja);
		this.nacimiento = fechaIngresoAGranja.minusDays(edadEnDiasAlIngresar);
		this.fechaExpiracion = nacimiento.plusDays(diasExpiracion);
		// this.edadActual = now.compareTo(nacimiento);
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
		return (super.toString() + " " + id + " " + animal + " Expira el " + fechaExpiracion + ".\n");
	}

	@Override
	public String getAnimal() {
		return animal;
	}

	@Override
	public void setAnimal(String animal) {
		this.animal = animal;
	}

	@Override
	public int getDiasExpiracion() {
		return diasExpiracion;
	}

	public void setDiasExpiracion(int diasExpiracion) {
		this.diasExpiracion = diasExpiracion;
	}

	@Override
	public LocalDate getFechaExpiracion() {
		return fechaExpiracion;
	}

	@Override
	public void setFechaExpiracion(LocalDate fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
	}


	@Override
	public void reproducir(LocalDate i) {
		//LocalDate i = nacimiento.plusDays(tiempoDeReproduccion);
		if (i.isBefore(now)) {
			
			if (i.equals(fechaExpiracion)) {
				System.out.println("Convierto huevo en pollito en la fecha: " + i);
				new Pollito(0, 0, i);
				//huevos = (ArrayList<Huevo>) huevos.stream().filter((h) -> {return h != huevo;}).collect(Collectors.toList());
				System.out.println("Pollito creado con fecha de nacimiento " + i);
				
			//i = i.plusDays(tiempoDeReproduccion);
		}
		super.reproducir(i);
	}
}}