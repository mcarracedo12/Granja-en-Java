package com.accenture.granja.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import io.micrometer.core.lang.NonNull;
@Entity
public class Animal {
	
	@Id
	@GeneratedValue
	protected long id;

	@ManyToOne
    @JoinColumn(name = "tipo_animal_id")
	protected TiposAnimales tiposAnimales;
	//protected String animal;// Lo busca por tipo de animal 
	@NonNull
	protected LocalDate fechaIngresoAGranja;
	
	protected int edadEnDiasAlIngresar;
	protected LocalDate nacimiento;// calcula ingreso-edad
	protected LocalDate fechaExpiracion; //nacimiento + expiracion por tipoAnimal
	//protected int tiempoDeReproduccion; // lo busca por tipo de animal
	protected int edadActual;// hoy - nacimiento
	//protected int cantidadMaxima; // Lo busca por tipo de animal 
	protected BigDecimal precioCompra;
	protected BigDecimal precioVenta;
	@ManyToOne
    @JoinColumn(name = "granja_id")
	protected Granja granjaId;

	public Animal(Long tipo_animal_id, int edadEnDiasAlIngresar, LocalDate fechaIngresoAGranja) {
		//this.id = id;
	//	this.animal= getAnimal();
		this.fechaIngresoAGranja = fechaIngresoAGranja;
		this.edadEnDiasAlIngresar = edadEnDiasAlIngresar;
		this.nacimiento = fechaIngresoAGranja.minusDays(edadEnDiasAlIngresar);
		this.fechaExpiracion = this.nacimiento.plusDays(getDiasExpiracion());
		//this.tiempoDeReproduccion= getTiempoDeReproduccion();
		this.edadActual = LocalDate.now().compareTo(this.getNacimiento());
		//this.cantidadMaxima = getCantidadMaxima();
	}

	public LocalDate getNacimiento() {
		return nacimiento;
	}

	public LocalDate getIngresoAGranja() {
		return fechaIngresoAGranja;
	}

	public void setIngresoAGranja(LocalDate ingresoAGranja) {
		this.fechaIngresoAGranja = ingresoAGranja;
	}
	
	public int getDiasExpiracion() {
        return tiposAnimales.getDiasExpiracion();
	}

	
	protected BigDecimal getPrecioCompra(){
        return tiposAnimales.getPrecioCompra();
	}
	
	protected BigDecimal getPrecioVenta(){
        return tiposAnimales.getPrecioVenta();
	}
	public int getCantidadMaxima() {
        return tiposAnimales.getCantidadMaxima();
	}
	
	public void reproducir(LocalDate i) {
	}
	
	public int getTiempoDeReproduccion() {
		return tiposAnimales.getTiempoDeReproduccion();
	}

	public int getEdadActual() {
		return edadActual;
	}
	
	public String getAnimal() {
		return tiposAnimales.getAnimal();
	}
	
	
/*	public void comprar(Ganado tipoGanado, int edad) {
		this.precioCompra = setPrecioCompraByAnimal();
	}
	
	public void vender(Ganado tipoGanado,int edad) {
		this.precioVenta= tipoGanado.setPrecioVentaByAnimal();
		
		//String cant = "10";
		//BigDecimal totalVenta = precioVenta.multiply(new BigDecimal(cant));
		//System.out.println("El total de la venta es de "+ totalVenta);
	}
*/
	public BigDecimal setPrecioVentaByAnimal() {
		return tiposAnimales.getPrecioVenta();
	}
	
	public BigDecimal setPrecioCompraByAnimal() {
		return tiposAnimales.getPrecioCompra();
	}
	
	public TiposAnimales getTiposAnimales() {
		return tiposAnimales;
	}

	public void setTiposAnimales(TiposAnimales tiposAnimales) {
		this.tiposAnimales = tiposAnimales;
	}

	@Override
	public String toString() {
		return String.format("Animal " +" " + getAnimal()  
				+ " . Tiempo de Reproduccion: " + getTiempoDeReproduccion() + ". Precios de compra y venta: " + precioCompra + " " + precioVenta + ". CantidadMaxima: " + getCantidadMaxima() + "\n");
	}

}