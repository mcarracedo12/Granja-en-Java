package com.accenture.granja.model;



import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity


public class Pollito extends Ganado {
	@Id
	@GeneratedValue
	private long id;
	protected String animal;
	public LocalDate fechaExpiracion;
	private LocalDate nacimiento;
	int tiempoDeReproduccion;
	protected int edadActual = LocalDate.now().compareTo(this.getNacimiento());
	@ManyToOne
	@JoinColumn(name = "tiposAnimales_id")
	public TiposAnimales tiposAnimales;

	public Pollito( Long tiposAnimales_id, int edadEnDiasAlIngresar, LocalDate fechaIngresoAGranja) {
		super(tiposAnimales_id, edadEnDiasAlIngresar, fechaIngresoAGranja);
		this.nacimiento = fechaIngresoAGranja.minusDays(edadEnDiasAlIngresar);
		this.animal = tipoAnimal.getAnimal();
		this.fechaExpiracion = nacimiento.plusDays(getDiasExpiracion());
		this.edadActual = LocalDate.now().compareTo(getNacimiento());
	}

	public void agregar(int diasEdad){
		new Pollito((long) 2, diasEdad, LocalDate.now()); 
	}
	
	@Override
	public void reproducir(LocalDate i) {
		if (i.isBefore(LocalDate.now())) {
			new Huevo((long)1, 0, i);
			System.out.println("Huevo creado con fecha de nacimiento " + i);
			//i = i.plusDays(tiempoDeReproduccion);
		}
		//super.reproducir(i);
	}
	
}