package com.accenture.granja.model;

import java.math.BigDecimal;
import java.time.LocalDate;


//@Entity

public class Pollito extends Animal {
	//@Id
	//@GeneratedValue
	protected Long id;
	
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
	

	public Pollito(Long tiposAnimales_id, int edadEnDiasAlIngresar, LocalDate fechaIngresoAGranja) {
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

	public void agregar(int diasEdad){
		new Pollito((long) 2, diasEdad, LocalDate.now()); 
	}
	
	@Override
	public void reproducir(LocalDate i) {
		if (i.isBefore(LocalDate.now())) {
			new Huevo((long)1, 0, i);
			System.out.println("Huevo creado con fecha de nacimiento " + i);
			//i = i.plusDays(tiempoDeReproduccion);
		}
		//super.reproducir(i);
	}
	
}