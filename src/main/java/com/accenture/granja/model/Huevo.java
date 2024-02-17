package com.accenture.granja.model;


import java.time.LocalDate;


//@Entity
public class Huevo extends Animal {
	//@Id
	//@GeneratedValue
	protected Long id;

	//@ManyToOne
	//@JoinColumn(name = "tiposAnimales_id")
	//public TiposAnimales tiposAnimales;
	
	//protected String animal;// Lo busca por tipo de animal 
	protected LocalDate fechaIngresoAGranja;
	protected int edadEnDiasAlIngresar;
	protected LocalDate nacimiento;// calcula ingreso-edad
	protected LocalDate fechaExpiracion; //nacimiento + expiracion por tipoAnimal
	//protected int tiempoDeReproduccion; // lo busca por tipo de animal
	//protected int edadActual;// hoy - nacimiento
	//protected int cantidadMaxima; // Lo busca por tipo de animal 
	//public double precioCompra;// Se setean al momento de la transaccion correspondiente
	//public double precioVenta; // Se setean al momento de la transaccion correspondiente


	public Huevo(Long tipo_animal_id, int edadEnDiasAlIngresar, LocalDate fechaIngresoAGranja) {
		super(tipo_animal_id, edadEnDiasAlIngresar, fechaIngresoAGranja);
		this.tiposAnimales= getAnimalById(tipo_animal_id);

		this.fechaIngresoAGranja = fechaIngresoAGranja;
		this.edadEnDiasAlIngresar = edadEnDiasAlIngresar;
		this.nacimiento = fechaIngresoAGranja.minusDays(edadEnDiasAlIngresar);
		this.fechaExpiracion = this.nacimiento.plusDays(getDiasExpiracionByTipo());
		//this.edadActual = LocalDate.now().compareTo(this.getNacimiento());
		//this.precioCompra= getPrecioCompraByTipo();
		//this.precioVenta= 0;
	}


	@Override
	public void reproducir() {
		LocalDate i = nacimiento.plusDays(getTiempoDeReproduccionByTipo());
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
				i = i.plusDays(getTiempoDeReproduccionByTipo());
			}
			
			
		}
	}
}