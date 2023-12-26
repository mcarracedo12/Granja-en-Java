package com.accenture.granja.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Huevo extends Ganado {
	@Id
	@GeneratedValue
	private long id;

	protected String animal;
	protected int diasExpiracion;
	protected LocalDate nacimiento;
	protected LocalDate fechaExpiracion;
	protected int tiempoDeReproduccion;
	protected int edadActual;

	@ManyToOne
	@JoinColumn(name = "tiposAnimales_id")
	public TiposAnimales tiposAnimales;
	

	public Huevo(Long tiposAnimales_id,  int edadEnDiasAlIngresar, LocalDate fechaIngresoAGranja) {
		super(tiposAnimales_id, edadEnDiasAlIngresar, fechaIngresoAGranja);
		this.nacimiento = fechaIngresoAGranja.minusDays(edadEnDiasAlIngresar);
		this.fechaExpiracion = nacimiento.plusDays(diasExpiracion);
		this.edadActual = LocalDate.now().compareTo(nacimiento);
		this.animal = tipoAnimal.getAnimal();
	}
	

	@Override
	public void reproducir(LocalDate i) {
		//LocalDate i = nacimiento.plusDays(tiempoDeReproduccion);
		if (i.isBefore(LocalDate.now())) {

			if (i.equals(fechaExpiracion)) {
				System.out.println("Convierto huevo en pollito en la fecha: " + i);
				new Pollito((long)2, 0, i);
				//List<Huevo> huevos = (ArrayList<Huevo>) huevos.stream().filter((h) -> {return h != this;}).collect(Collectors.toList());
				System.out.println("Pollito creado con fecha de nacimiento " + i);

				//i = i.plusDays(tiempoDeReproduccion);
			}
			//super.reproducir(i);
		}
	}
}