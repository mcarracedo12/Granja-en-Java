package com.accenture.granja.model;

import java.math.BigDecimal;
import java.time.LocalDate;


//@Entity
public class Huevo extends Animal {
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


	public Huevo(Integer i,  int edadEnDiasAlIngresar, LocalDate fechaIngresoAGranja) {
		super(i, edadEnDiasAlIngresar, fechaIngresoAGranja);
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
				new Pollito(2, 0, i);
				//List<Huevo> huevos = (ArrayList<Huevo>) huevos.stream().filter((h) -> {return h != this;}).collect(Collectors.toList());
				System.out.println("Pollito creado con fecha de nacimiento " + i);

				//i = i.plusDays(tiempoDeReproduccion);
			}
			//super.reproducir(i);
		}
	}
}