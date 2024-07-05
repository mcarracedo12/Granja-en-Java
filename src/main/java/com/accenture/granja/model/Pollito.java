package com.accenture.granja.model;


import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


public class Pollito extends Animal {

	public Pollito(Long tipo_animal_id, int edadEnDiasAlIngresar, LocalDate fechaIngresoAGranja) {
		super(tipo_animal_id, edadEnDiasAlIngresar, fechaIngresoAGranja);
		this.tiposAnimales= getAnimalById(2L);
		this.fechaIngresoAGranja = fechaIngresoAGranja;
		this.edadEnDiasAlIngresar = edadEnDiasAlIngresar;
		this.nacimiento = fechaIngresoAGranja.minusDays(edadEnDiasAlIngresar);
		this.fechaExpiracion = this.nacimiento.plusDays(getTiposAnimales().getDiasExpiracion());
		//this.edadActual = LocalDate.now().compareTo(this.getNacimiento());
		//this.precioCompra= getPrecioCompraByTipo();
		//this.precioVenta= 0;
	}


	
	@Override
	public void reproducir() {
		LocalDate i = granja.getUltimaActualizacion();
		if (i.isBefore(LocalDate.now())) {
			Huevo huevo = new Huevo((long)1,0, i);
			agregar((long)1, 0, i);
			huevo.reproducir();
			System.out.println("Huevo creado con fecha de nacimiento " + i);
			i = i.plusDays( getTiposAnimales().getTiempoDeReproduccion());
		}
	
	}
	
}