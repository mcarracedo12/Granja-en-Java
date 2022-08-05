package com.granja;

import java.math.BigDecimal;

public class TiposAnimales {
	int id;
	String animal;
	int diasExpiracion;
	BigDecimal precioCompra;
	BigDecimal precioVenta;
	public TiposAnimales(int id, String animal, int diasExpiracion, String precioCompra, String precioVenta) {
		this.id = id;
		this.animal = animal;
		this.diasExpiracion = diasExpiracion;
		this.precioCompra = new BigDecimal(precioCompra);
		this.precioVenta = new BigDecimal(precioVenta);
	}

}
