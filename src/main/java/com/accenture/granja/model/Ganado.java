package com.accenture.granja.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public abstract class Ganado {
	
	//@Id
	//@GeneratedValue
	//private long id;

	@ManyToOne
    @JoinColumn(name = "tipo_animal_id")
	protected TiposAnimales tipoAnimal;
	protected String animal;
	protected LocalDate fechaIngresoAGranja;
	protected int edadEnDiasAlIngresar;
	protected LocalDate nacimiento;
	
	
	
	protected LocalDate fechaExpiracion;
	

	protected int tiempoDeReproduccion;
	protected int edadActual;
	protected BigDecimal precioCompra;
	protected BigDecimal precioVenta;
	protected int cantidadMaxima ;

	public Ganado(Long tipo_animal_id, int edadEnDiasAlIngresar, LocalDate fechaIngresoAGranja) {
		//this.id = id;
		this.animal= tipoAnimal.getAnimal();
		this.fechaIngresoAGranja = fechaIngresoAGranja;
		this.edadEnDiasAlIngresar = edadEnDiasAlIngresar;
		this.nacimiento = fechaIngresoAGranja.minusDays(edadEnDiasAlIngresar);
		
		this.fechaExpiracion = this.nacimiento.plusDays(getDiasExpiracion());
		this.tiempoDeReproduccion= getTiempoDeReproduccion();
		this.edadActual = LocalDate.now().compareTo(this.getNacimiento());
		
		cantidadMaxima = getCantidadMaxima();
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
	
	public int getTiempoDeReproduccion() {
		return tipoAnimal.getTiempoDeReproduccion();
	}

	public int getEdadActual() {
		return edadActual;
	}
	
	public String getAnimal() {
		return tipoAnimal.getAnimal();
	}
	
	public void comprar(Ganado tipoGanado, int edad) {
		this.precioCompra = setPrecioCompraByAnimal();
	}
	
	public void vender(Ganado tipoGanado,int edad) {
		this.precioVenta= tipoGanado.setPrecioVentaByAnimal();
		
		//String cant = "10";
		//BigDecimal totalVenta = precioVenta.multiply(new BigDecimal(cant));
		//System.out.println("El total de la venta es de "+ totalVenta);
	}

	public BigDecimal setPrecioVentaByAnimal() {
		return tipoAnimal.getPrecioVenta();
	}
	
	public BigDecimal setPrecioCompraByAnimal() {
		return tipoAnimal.getPrecioCompra();
	}
	
	@Override
	public String toString() {
		return String.format("Animal " +" " + animal  
				+ " . Tiempo de Reproduccion: " + tiempoDeReproduccion + ". Precios de compra y venta: " + precioCompra + " " + precioVenta + ". CantidadMaxima: " + cantidadMaxima + "\n");
	}

}