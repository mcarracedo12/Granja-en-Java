package com.accenture.granja.model;




import java.time.LocalDate;

// Esta clase convierte el animal en producto para las transacciones (Venta y Compra)

public abstract class Producto {
	private Long id;
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

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	private LocalDate fechaExpiracion;
	private double precio;

	public Producto(String animal, LocalDate fechaExpiracion, double precio) {
		this.fechaExpiracion = fechaExpiracion;
		this.precio = precio;
	}

}