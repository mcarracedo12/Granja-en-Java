package com.accenture.granja.model;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class TiposAnimales {
	@Id
	@GeneratedValue
	private int id;
	private String animal;
	private int diasExpiracion;
	private int cantidadMaxima;
	private int tiempoDeReproduccion;
	private BigDecimal precioCompra;
	private BigDecimal precioVenta;
	
	@OneToMany(mappedBy = "tiposAnimales", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Pollito> pollitos = new ArrayList<Pollito>();
	@ManyToOne
	@JoinColumn(name = "granja_id")
	public Granja granja;

							
	public TiposAnimales(int id, String animal, int diasExpiracion, int cantidadMaxima, int tiempoDeReproduccion, BigDecimal precioCompra,
			BigDecimal precioVenta) {
		this.id = id;
		this.animal = animal;
		this.diasExpiracion = diasExpiracion;
		this.cantidadMaxima = cantidadMaxima;
		this.tiempoDeReproduccion =tiempoDeReproduccion;
		this.precioCompra = precioCompra;
		this.precioVenta = precioVenta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAnimal() {
		return animal;
	}

	public void setAnimal(String animal) {
		this.animal = animal;
	}

	public int getDiasExpiracion() {
		return diasExpiracion;
	}

	public void setDiasExpiracion(int diasExpiracion) {
		this.diasExpiracion = diasExpiracion;
	}
	
	public int getCantidadMaxima() {
		return cantidadMaxima;
	}

	public void setCantidadMaxima(int cantidadMaxima) {
		this.cantidadMaxima = cantidadMaxima;
	}

	public BigDecimal getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(BigDecimal precioCompra) {
		this.precioCompra = precioCompra;
	}

	public BigDecimal getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(BigDecimal precioVenta) {
		this.precioVenta = precioVenta;
	}

	
	
	
	

	@Override
	public String toString() {
		return String.format("Animal " + id + " " + animal + ". \nDias de Expiracion: " + diasExpiracion +  ". \nCantidadMaxima: "+ cantidadMaxima + ". \nTiempo De Reproduccion: " + tiempoDeReproduccion +". \nPrecio de compra " + precioCompra +". \nPrecio de venta: " + precioVenta  +".\n\n");
	}

	

	public int getTiempoDeReproduccion() {
		return tiempoDeReproduccion;
	}

	public void setTiempoDeReproduccion(int tiempoDeReproduccion) {
		this.tiempoDeReproduccion = tiempoDeReproduccion;
	}

	//public int getTiempoDeReproduccionByAnimal(int animal_id) {
		//return tiempoDeReproduccion;
	//}

	/*public void setTiempoDeReproduccion(int tiempoDeReproduccion) {
		this.tiempoDeReproduccion = tiempoDeReproduccion;
	}
*/

}