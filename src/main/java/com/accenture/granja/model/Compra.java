package com.accenture.granja.model;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.persistence.Entity;

@Entity
public class Compra extends Transaccion {

   
	public Compra(String nombrePersona, ArrayList<Animal> productos,  LocalDate fecha) {
		super(nombrePersona, productos,  fecha);
	}

}