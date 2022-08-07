package com.granja;

import java.math.BigDecimal;
import java.time.LocalDate;

// Esta clase convierte el animal en producto para las transacciones (Venta y Compra)

public abstract class Producto {
	LocalDate now = LocalDate.now();
	private int id;
	private String animal;
	private LocalDate fechaExpiracion;
	private BigDecimal precio;

	public Producto(int id, String animal, LocalDate fechaExpiracion, BigDecimal precio) {
		this.id = id;
		this.fechaExpiracion = fechaExpiracion;
		this.precio = precio;
	}

}