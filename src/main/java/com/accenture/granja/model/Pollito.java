package com.accenture.granja.model;


import java.time.LocalDate;


//@Entity

public class Pollito extends Animal {
	//@Id
	//@GeneratedValue
	protected Long id;
	
	protected LocalDate fechaIngresoAGranja;
	protected int edadEnDiasAlIngresar;
	protected LocalDate nacimiento;// calcula ingreso-edad
	protected LocalDate fechaExpiracion; //nacimiento + expiracion por tipoAnimal
	//protected int tiempoDeReproduccion; // lo busca por tipo de animal
	//protected int edadActual;// hoy - nacimiento
	//protected int cantidadMaxima; // Lo busca por tipo de animal 
	//public double precioCompra;// Se setean al momento de la transaccion correspondiente
	//public double precioVenta; // Se setean al momento de la transaccion correspondiente
	

	public Pollito(Long tipo_animal_id, int edadEnDiasAlIngresar, LocalDate fechaIngresoAGranja) {
		super(tipo_animal_id, edadEnDiasAlIngresar, fechaIngresoAGranja);
		this.tiposAnimales= getAnimalById(tipo_animal_id);
		this.fechaIngresoAGranja = fechaIngresoAGranja;
		this.edadEnDiasAlIngresar = edadEnDiasAlIngresar;
		this.nacimiento = fechaIngresoAGranja.minusDays(edadEnDiasAlIngresar);
		this.fechaExpiracion = this.nacimiento.plusDays(getDiasExpiracionByTipo());
		//this.edadActual = LocalDate.now().compareTo(this.getNacimiento());
		//this.precioCompra= getPrecioCompraByTipo();
		//this.precioVenta= 0;
	}


	
	@Override
	public void reproducir(LocalDate i) {
		if (i.isBefore(LocalDate.now())) {
			//new Huevo(1, 0, i);
			System.out.println("Huevo creado con fecha de nacimiento " + i);
			//i = i.plusDays(tiempoDeReproduccion);
		}
		//super.reproducir(i);
	}
	
}