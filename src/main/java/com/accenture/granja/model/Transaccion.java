package com.accenture.granja.model;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Transaccion {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nombrePersona; // Cliente / comprador segun sea la transaccion
	private ArrayList<Animal> productos = new ArrayList<>();
	private LocalDate fecha;
	private double total;
	
	public Transaccion(String nombrePersona, ArrayList<Animal> productos, LocalDate fecha) {
		super();
		this.nombrePersona = nombrePersona;
		this.productos = productos;
		this.fecha = fecha;
		this.total=setTotal();
	}

	public String getNombrePersona() {
		return nombrePersona;
	}

	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}

	public ArrayList<Animal> getProductos() {
		return productos;
	}

	public double setTotal() {
		for (Animal producto : productos) {
			double total = 0;
			//total = total + producto.getPrecio();// Aca segun si es compra o venta es el precio que sumo
			// total = total.reduce(total, producto.getPrecio());
		}
		return total;
	}

	public double getTotal() {
		return total;
	}



	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

}