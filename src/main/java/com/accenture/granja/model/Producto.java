package com.accenture.granja.model;



import java.math.BigDecimal;
import java.time.LocalDate;

// Esta clase convierte el animal en producto para las transacciones (Venta y Compra)

public abstract class Producto {
	LocalDate now = LocalDate.now();
	private long id;
	private String animal;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAnimal() {
		return animal;
	}

	public void setAnimal(String animal) {
		this.animal = animal;
	}

	public LocalDate getFechaExpiracion() {
		return fechaExpiracion;
	}

	public void setFechaExpiracion(LocalDate fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	private LocalDate fechaExpiracion;
	private BigDecimal precio;

	public Producto(long id, String animal, LocalDate fechaExpiracion, BigDecimal precio) {
		this.id = id;
		this.fechaExpiracion = fechaExpiracion;
		this.precio = precio;
	}

}