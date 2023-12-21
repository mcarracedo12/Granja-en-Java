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
	
	private String animal= tipoAnimal.getAnimal();
	private int diasExpiracion = getDiasExpiracionByAnimal();
	private LocalDate nacimiento;
	public LocalDate fechaExpiracion;
	int tiempoDeReproduccion;
	private int edadActual;

	@ManyToOne
	@JoinColumn(name = "tiposAnimales_id")
	private TiposAnimales tiposAnimales;
	
	public Huevo(long id, int edadEnDiasAlIngresar, LocalDate fechaIngresoAGranja) {
		super(id, edadEnDiasAlIngresar, fechaIngresoAGranja);
		this.nacimiento = fechaIngresoAGranja.minusDays(edadEnDiasAlIngresar);
		this.fechaExpiracion = nacimiento.plusDays(diasExpiracion);
		this.edadActual = LocalDate.now().compareTo(nacimiento);
	}




/*	@Override
	public void setNacimiento(LocalDate nacimiento) {
		this.nacimiento = fechaIngresoAGranja.minusDays(edadEnDiasAlIngresar);
	}
*/
/*	@Override
	public String toString() {
		return (super.toString() + " " + id + " " + animal + " Expira el " + fechaExpiracion + ".\n");
	}
*/

/*	public void setDiasExpiracion(int diasExpiracion) {
		this.diasExpiracion = diasExpiracion;
	}

*/	
	


	@Override
	public void reproducir(LocalDate i) {
		//LocalDate i = nacimiento.plusDays(tiempoDeReproduccion);
		if (i.isBefore(LocalDate.now())) {
			
			if (i.equals(fechaExpiracion)) {
				System.out.println("Convierto huevo en pollito en la fecha: " + i);
				new Pollito(0, 0, i);
				//List<Huevo> huevos = (ArrayList<Huevo>) huevos.stream().filter((h) -> {return h != this;}).collect(Collectors.toList());
				System.out.println("Pollito creado con fecha de nacimiento " + i);
				
			//i = i.plusDays(tiempoDeReproduccion);
		}
		super.reproducir(i);
	}
}}