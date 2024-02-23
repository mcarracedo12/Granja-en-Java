package com.accenture.granja.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;

import com.accenture.granja.repository.TipoAnimalRepository;
import com.accenture.granja.services.TipoAnimalService;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class TiposAnimales {
	
//	@Autowired
//	private TipoAnimalService tipoAnimalService;
	
//	@Autowired
	//private TipoAnimalRepository tiposAnimalesRepository;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String animal;
	private int diasExpiracion;// Expectativa de vida del animal: 21 dias huevos - 2000 dias pollos 
	private int cantidadMaxima;
	private int tiempoDeReproduccion; // cada cuanto se reproduce: - 21 dias huevos - 1 dia pollos 
	private double precioCompra; // Los precios se actualizan a nivel tipoAnimal, por cada Transaccion se toma el precio de ahi para los productos
	private double precioVenta;
	private String imagen;
	
	@OneToMany(mappedBy = "tiposAnimales", cascade = CascadeType.ALL, orphanRemoval = true)
	//@JsonIgnore
	public List<Animal> animales;
	
	@NonNull
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnore
	@JoinColumn(name = "granja_id")
	public Granja granja;
	

	
	//Agrego para que no tire error despues nada mas, no deberia hacer falta
	public TiposAnimales() {
		super();
	}
	
	public TiposAnimales(String animal, int diasExpiracion, int cantidadMaxima, int tiempoDeReproduccion, double precioCompra, double precioVenta) {
		this.animal = animal;
		this.diasExpiracion = diasExpiracion;
		this.cantidadMaxima = cantidadMaxima;
		this.tiempoDeReproduccion =tiempoDeReproduccion;
		this.precioCompra = precioCompra;
		this.precioVenta = precioVenta;
	}

	public long getId() {
		try {
			return id;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAnimal() {
		return animal;
	}

	public void setAnimal(String animal) {
		this.animal = animal;
	}

	public List<Animal> getAnimales() {
		return animales;
	}

	public void setAnimales(List<Animal> animales) {
		this.animales = animales;
	}

	public int getDiasExpiracion() {
		return diasExpiracion;
	}

	public void setDiasExpiracion(int diasExpiracion) {
		this.diasExpiracion = diasExpiracion;
	}
	
	public int getCantidadMaxima() {
		return cantidadMaxima;
	}

	public void setCantidadMaxima(int cantidadMaxima) {
		this.cantidadMaxima = cantidadMaxima;
	}

	public double getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}
	
	public int getTiempoDeReproduccion() {
		return tiempoDeReproduccion;
	}

	public void setTiempoDeReproduccion(int tiempoDeReproduccion) {
		this.tiempoDeReproduccion = tiempoDeReproduccion;
	}
	
	

	/*public void mostrarDetallesCadaAnimal() {
		for(Ganado animal: huevos) {
		System.out.println(animalH.toString());	
		}
		for(Ganado animalP: pollitos) {
			System.out.println(animalP.toString());	
		}
		
	}
*/
/*	public ArrayList<Pollito> getPollitos() {
		System.out.println("tipos animales get Pollitos to stream\n");
		return pollitos;
	}
	*/
/*	public List<Pollito> addPollito(Pollito pollito) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Ingrese edad del pollitos");	
			int edad = scanner.nextInt();

			pollito.agregar(edad);
		}
		System.out.println("Pollito agregado");
		return pollitos;
	}
	
	*/
	
	
	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Override
	public String toString() {
		return String.format("Animal: " 
	//+ getId()
		+ " " 
	+ getAnimal() + ". \nDias de Expiracion: " + getDiasExpiracion() +  ". \nCantidad Maxima: "+ getCantidadMaxima() + ". \nTiempo De Reproduccion: " + getTiempoDeReproduccion() +". \nPrecio de compra " + getPrecioCompra() +". \nPrecio de venta: " + getPrecioVenta()  +".\n\n");
	}

	public TiposAnimales getById(Long tipo_animal_id) {
		// TODO Auto-generated method stub
		return this;
	}
	
	public Granja getGranja() {
		if(granja== null) {
			return null;
		}else
		return granja;
	}
	

	public void setGranja(Granja granja) {
		if(granja!= null) {	
		this.granja = granja;
		}
	}
	
	
	public long getGranjaId() {
		long id=(long)-1;
		if (granja!=null) {
			id = granja.getId();
		}
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void agregar(TiposAnimales tipo1) {
		//TipoAnimalService.agregarTipo(tipo1);
		System.out.println("Quiero hacer el post aca en TiposAnimales.agregar(tipo)");
		//tiposAnimalesRepository.save(tipo1);
	}
	

	/*public void setTiempoDeReproduccion(int tiempoDeReproduccion) {
		this.tiempoDeReproduccion = tiempoDeReproduccion;
	}
*/
	
/*
	public List<Pollito> getPollitos(){
		for (Pollito p: pollitos) {
			System.out.println(p.toString());
		}
		return pollitos;
	}
	*/
	/*public void printHuevos(){
		for (Huevo h: huevos) {
			System.out.println(h.toString());
		}
	}
	
	public void agregaPollito(int dias) {
		pollitos.add(new Pollito((long)2,dias,LocalDate.now()));
	}
	public void agregahuevo(int dias) {
		huevos.add(new Huevo((long)2,dias,LocalDate.now()));
	}
	*/
	/*public List<Ganado> getAnimalesByTipo1(int id) {
		switch(id) {
		case 1:
			return huevos;
			break;
		
		case 2:
		return pollitos;
		break;
	}
*/
/*	public void addHuevo() {
		huevos.add(new Huevo((long)1, 0, LocalDate.now()));
	}
*/
	
	
	

}