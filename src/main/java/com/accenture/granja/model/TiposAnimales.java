package com.accenture.granja.model;


import java.math.BigDecimal;

public class TiposAnimales {
	private int id;
	private String animal;
	private int diasExpiracion;
	private BigDecimal precioCompra;
	private BigDecimal precioVenta;
	private int cantidadMaxima;

	public TiposAnimales(int id, String animal, int diasExpiracion, int cantidadMaxima, BigDecimal precioCompra,
			BigDecimal precioVenta) {
		this.id = id;
		this.animal = animal;
		this.diasExpiracion = diasExpiracion;
		this.precioCompra = precioCompra;
		this.precioVenta = precioVenta;
		this.cantidadMaxima = cantidadMaxima;
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

	public int getCantidadMaxima() {
		return cantidadMaxima;
	}

	public void setCantidadMaxima(int cantidadMaxima) {
		this.cantidadMaxima = cantidadMaxima;
	}

	@Override
	public String toString() {
		return "Animal " + id + " " + animal + " . Dias de Expiracion: " + diasExpiracion
				+ ". Precios de compra y venta: " + precioCompra + " " + precioVenta + ". CantidadMaxima: "
				+ cantidadMaxima + "\n";
	}

	public int getDiasExpiracionByAnimal(String animal) {
		return diasExpiracion;
	}


}