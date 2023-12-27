package com.accenture.granja.model;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class TiposAnimales {
	@Id
	@GeneratedValue
	private int id;
	private String animal;
	private int diasExpiracion;// Expectativa de vida del animal: 21 dias huevos - 2000 dias pollos 
	private int cantidadMaxima;
	private int tiempoDeReproduccion; // cada cuanto se reproduce: - 21 dias huevos - 1 dia pollos 
	private BigDecimal precioCompra; // Los precios se actualizan a nivel tipoAnimal, por cada Transaccion se toma el precio de ahi para los productos
	private BigDecimal precioVenta;
	@OneToMany(mappedBy = "tiposAnimales", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Huevo> huevos = new ArrayList<Huevo>();
	@OneToMany(mappedBy = "tiposAnimales", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Pollito> pollitos = new ArrayList<Pollito>();
	
	
	@ManyToOne
	@JoinColumn(name = "granja_id")
	public Granja granja;

							
	public TiposAnimales(int id, String animal, int diasExpiracion, int cantidadMaxima, int tiempoDeReproduccion, BigDecimal precioCompra,
			BigDecimal precioVenta) {
		this.id = id;
		this.animal = animal;
		this.diasExpiracion = diasExpiracion;
		this.cantidadMaxima = cantidadMaxima;
		this.tiempoDeReproduccion =tiempoDeReproduccion;
		this.precioCompra = precioCompra;
		this.precioVenta = precioVenta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAnimal() {
		return animal;
	}

	public void setAnimal(String animal) {
		this.animal = animal;
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

	public BigDecimal getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(BigDecimal precioCompra) {
		this.precioCompra = precioCompra;
	}

	public BigDecimal getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(BigDecimal precioVenta) {
		this.precioVenta = precioVenta;
	}
	
	public int getTiempoDeReproduccion() {
		return tiempoDeReproduccion;
	}

	public void setTiempoDeReproduccion(int tiempoDeReproduccion) {
		this.tiempoDeReproduccion = tiempoDeReproduccion;
	}

	public void mostrarDetallesCadaAnimal() {
		for(Ganado animalH: huevos) {
		System.out.println(animalH.toString());	
		}
		for(Ganado animalP: pollitos) {
			System.out.println(animalP.toString());	
		}
		
	}

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
	
	
	@Override
	public String toString() {
		return String.format("Animal " + id + " " + animal + ". \nDias de Expiracion: " + diasExpiracion +  ". \nCantidadMaxima: "+ cantidadMaxima + ". \nTiempo De Reproduccion: " + tiempoDeReproduccion +". \nPrecio de compra " + precioCompra +". \nPrecio de venta: " + precioVenta  +".\n\n");
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
	/*public List<Ganado> getAnimalesByid1(Long id) {
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