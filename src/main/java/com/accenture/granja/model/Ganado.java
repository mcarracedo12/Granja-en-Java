package com.accenture.granja.model;

import java.math.BigDecimal;
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
	protected String animal= getAnimal();
	public LocalDate fechaExpiracion;
	private int diasExpiracion = getDiasExpiracion();
	int tiempoDeReproduccion;
	protected int edadActual;
	BigDecimal precioCompra = getPrecioCompra();
	BigDecimal precioVenta = getPrecioVenta();
	int cantidadMaxima = getCantidadMaxima();

	public Ganado(long id, int edadEnDiasAlIngresar, LocalDate fechaIngresoAGranja) {
		//this.id = id;
		this.edadEnDiasAlIngresar = edadEnDiasAlIngresar;
		this.fechaIngresoAGranja = fechaIngresoAGranja;
		this.nacimiento = fechaIngresoAGranja.minusDays(edadEnDiasAlIngresar);
		this.animal= getAnimal();
		this.fechaExpiracion = this.nacimiento.plusDays(diasExpiracion);
		this.edadActual = LocalDate.now().compareTo(this.getNacimiento());
		
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
	
	public int getDiasExpiracion() {
        return tipoAnimal.getDiasExpiracion();
	}
	
	protected String getAnimal(){
        return tipoAnimal.getAnimal();
	}
	
	protected BigDecimal getPrecioCompra(){
        return tipoAnimal.getPrecioCompra();
	}
	
	protected BigDecimal getPrecioVenta(){
        return tipoAnimal.getPrecioVenta();
	}
	public int getCantidadMaxima() {
        return tipoAnimal.getCantidadMaxima();
	}
	
	public void reproducir(LocalDate i) {
			
	}

	public int getEdadActual() {
		return edadActual;
	}

	@Override
	public String toString() {
		return String.format("Animal " +" " + animal + " . Dias de Expiracion: " + diasExpiracion 
				+ " . Tiempo de Reproduccion: " + tiempoDeReproduccion + ". Precios de compra y venta: " + precioCompra + " " + precioVenta + ". CantidadMaxima: " + cantidadMaxima + "\n");
	}

}