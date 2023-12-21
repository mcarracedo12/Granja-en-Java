package com.accenture.granja.model;

import java.time.LocalDate;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public abstract class Ganado {
	
	//@Id
	//@GeneratedValue
	//private long id;
	protected int edadEnDiasAlIngresar;
	private LocalDate nacimiento;
	protected LocalDate fechaIngresoAGranja;
	
	@ManyToOne
    @JoinColumn(name = "tipo_animal_id")
	protected TiposAnimales tipoAnimal;
	private String animal= getAnimalByTipoAnimal();
	public LocalDate fechaExpiracion;
	private int diasExpiracion;
	int tiempoDeReproduccion;
	protected int edadActual;

	public Ganado(long id, int edadEnDiasAlIngresar, LocalDate fechaIngresoAGranja) {
		//this.id = id;
		this.edadEnDiasAlIngresar = edadEnDiasAlIngresar;
		this.nacimiento = fechaIngresoAGranja.minusDays(edadEnDiasAlIngresar);
		this.fechaIngresoAGranja = fechaIngresoAGranja;
		//this.animal= getAnimalByTipoAnimal(tipoAnimal);
		this.fechaExpiracion = this.nacimiento.plusDays(diasExpiracion);
		this.edadActual = setEdadActual();
		
		
	}

	public LocalDate getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(LocalDate nacimiento) {
		this.nacimiento = nacimiento;
	}

	public LocalDate getIngresoAGranja() {
		return fechaIngresoAGranja;
	}

	public void setIngresoAGranja(LocalDate ingresoAGranja) {
		this.fechaIngresoAGranja = ingresoAGranja;
	}

/*		public void setPrecioVenta(String animal) {
	 tiposAnimales.getPrecioVenta(String animal) = precioVenta;
	 this.setPrecioVenta(animal); // hay que ver si funciona esto...
		}
*/
/*	@Override
	public String toString() {
		return String.format("Fecha nacimiento - %s, Ingreso a Granja - %s, \n ", nacimiento,
				fechaIngresoAGranja);
	}
*/

/*	public int getEdadEnDiasAlIngresar() {
		return edadEnDiasAlIngresar;
	}
*/
/*	public void setEdadEnDiasAlIngresar(int edadEnDiasAlIngresar) {
		this.edadEnDiasAlIngresar = edadEnDiasAlIngresar;
	}
*/
	
	
	public int getDiasExpiracionByAnimal(int tipoAnimal_id) {
		return tipoAnimal.getDiasExpiracion();
	}

	public int getDiasExpiracionByAnimal() {
        return tipoAnimal.getDiasExpiracion();
}
	
	protected String getAnimalByTipoAnimal(){
        return tipoAnimal.getAnimal();
	}

	

/*	public String getAnimal() {
		return animal;
	}
*/
	
	public void reproducir(LocalDate i) {
			
	}

	

	public int getEdadActual() {
		return edadActual;
	}

	public int setEdadActual() {
		return this.edadActual = LocalDate.now().compareTo(this.getNacimiento());
	}

	@Override
	public String toString() {
		return String.format("Stringto Srting Ganado");
		//return String.format("Animal " + id + " " + animal + " . Dias de Expiracion: " + diasExpiracion 
				//+ " . Tiempo de Reproduccion: " + tiempoDeReproduccion
			//	+ ". Precios de compra y venta: " + precioCompra + " " + precioVenta + ". CantidadMaxima: "
			//	+ cantidadMaxima 
			//	+ "\n");
	}


}