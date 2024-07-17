package com.accenture.granja.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Transaccion {

	protected String nombrePersona; // Cliente / comprador segun sea la transaccion
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	protected LocalDate fecha;
	
	public Transaccion(String nombrePersona, LocalDate fecha) {
		super();
		this.nombrePersona = nombrePersona;
		this.fecha = fecha;
	}

	public Transaccion() {
	}

}