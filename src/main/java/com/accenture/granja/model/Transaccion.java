package com.accenture.granja.model;

import java.time.LocalDate;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Transaccion {

	protected String nombrePersona; // Cliente / comprador segun sea la transaccion
	
	protected LocalDate fecha;
	
	public Transaccion(String nombrePersona, LocalDate fecha) {
		super();
		this.nombrePersona = nombrePersona;
		this.fecha = fecha;
	}

	public Transaccion() {
		// TODO Auto-generated constructor stub
	}


}