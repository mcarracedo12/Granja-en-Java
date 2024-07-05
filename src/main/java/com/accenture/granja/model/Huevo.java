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


public class Huevo extends Animal {

	public Huevo(Long tipo_animal_id, int edadEnDiasAlIngresar, LocalDate fechaIngresoAGranja) {
		super(tipo_animal_id, edadEnDiasAlIngresar, fechaIngresoAGranja);
		this.tiposAnimales= getAnimalById(1L);

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
		LocalDate i = nacimiento.plusDays(getTiposAnimales().getTiempoDeReproduccion());
		if (i.isBefore(LocalDate.now())) {

			if (i.equals(fechaExpiracion)) {
				System.out.println("Convierto huevo en pollito en la fecha: " + i);
				Pollito pollito = new Pollito((long)2, 0, i);
				agregar((long)2, 0, i);
				pollito.reproducir();
				//List<Huevo> huevos = (ArrayList<Huevo>) huevos.stream().filter((h) -> {return h != this;}).collect(Collectors.toList());
				System.out.println("Pollito creado con fecha de nacimiento " + i);
				//this.eliminar(getId());
				System.out.println("Hay que eliminar Animal id " + getId());
				//eliminar(getId());
				i = i.plusDays(getTiposAnimales().getTiempoDeReproduccion());
			}
			
			
		}
	}
}