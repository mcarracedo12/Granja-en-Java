package com.accenture.granja.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//@Entity
public class Huevo extends Animal {
	//@Id
	//@GeneratedValue
	protected long id;

	//@ManyToOne
	//@JoinColumn(name = "tiposAnimales_id")
	//public TiposAnimales tiposAnimales;
	
	//protected String animal;// Lo busca por tipo de animal 
	protected LocalDate fechaIngresoAGranja;
	protected int edadEnDiasAlIngresar;
	protected LocalDate nacimiento;// calcula ingreso-edad
	protected LocalDate fechaExpiracion; //nacimiento + expiracion por tipoAnimal
	//protected int tiempoDeReproduccion; // lo busca por tipo de animal
	protected int edadActual;// hoy - nacimiento
	//protected int cantidadMaxima; // Lo busca por tipo de animal 
	protected BigDecimal precioCompra;
	protected BigDecimal precioVenta;


	public Huevo(Long tiposAnimales_id,  int edadEnDiasAlIngresar, LocalDate fechaIngresoAGranja) {
		super(tiposAnimales_id, edadEnDiasAlIngresar, fechaIngresoAGranja);
		//this.animal= getAnimal();
		this.fechaIngresoAGranja = fechaIngresoAGranja;
		this.edadEnDiasAlIngresar = edadEnDiasAlIngresar;
		this.nacimiento = fechaIngresoAGranja.minusDays(edadEnDiasAlIngresar);
		this.fechaExpiracion = this.nacimiento.plusDays(getDiasExpiracion());
		//this.tiempoDeReproduccion= getTiempoDeReproduccion();
		this.edadActual = LocalDate.now().compareTo(this.getNacimiento());
		//this.cantidadMaxima = getCantidadMaxima();
	}
	

	@Override
	public void reproducir(LocalDate i) {
		//LocalDate i = nacimiento.plusDays(tiempoDeReproduccion);
		if (i.isBefore(LocalDate.now())) {

			if (i.equals(fechaExpiracion)) {
				System.out.println("Convierto huevo en pollito en la fecha: " + i);
				new Pollito((long)2, 0, i);
				//List<Huevo> huevos = (ArrayList<Huevo>) huevos.stream().filter((h) -> {return h != this;}).collect(Collectors.toList());
				System.out.println("Pollito creado con fecha de nacimiento " + i);

				//i = i.plusDays(tiempoDeReproduccion);
			}
			//super.reproducir(i);
		}
	}
}