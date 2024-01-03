package com.accenture.granja.model;


import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import io.micrometer.core.lang.NonNull;
@Entity
public class Animal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	protected int id;

	@ManyToOne
    @JoinColumn(name = "tipo_animal_id")
	protected TiposAnimales tiposAnimales;
	//protected String animal;// Lo busca por tipo de animal 
	@NonNull
	protected LocalDate fechaIngresoAGranja;
	
	protected int edadEnDiasAlIngresar;
	protected LocalDate nacimiento;// calcula ingreso-edad
	protected LocalDate fechaExpiracion; //nacimiento + expiracion por tipoAnimal
	//protected int tiempoDeReproduccion; // lo busca por tipo de animal
	protected int edadActual;// hoy - nacimiento
	//protected int cantidadMaxima; // Lo busca por tipo de animal 
	protected double precioCompra;// Se setean al momento de la transaccion correspondiente
	protected double precioVenta; // Se setean al momento de la transaccion correspondiente
	@ManyToOne
   @JoinColumn(name = "granja_id")
	protected Granja granjaId;

	//Agrego para que no tire error despues nada mas, no deberia hacer falta
	public Animal() {
		super();
	}

	public Animal(Integer i, int edadEnDiasAlIngresar, LocalDate fechaIngresoAGranja) {
		//this.id = id;
	//	this.animal= getAnimal();
		this.fechaIngresoAGranja = fechaIngresoAGranja;
		this.edadEnDiasAlIngresar = edadEnDiasAlIngresar;
		this.nacimiento = fechaIngresoAGranja.minusDays(edadEnDiasAlIngresar);
		this.fechaExpiracion = this.nacimiento.plusDays(this.getDiasExpiracion());
		//this.tiempoDeReproduccion= getTiempoDeReproduccion();
		this.edadActual = LocalDate.now().compareTo(this.getNacimiento());
		//this.cantidadMaxima = getCantidadMaxima();
	}

	public LocalDate getNacimiento() {
		return nacimiento;
	}

	public LocalDate getIngresoAGranja() {
		return fechaIngresoAGranja;
	}

	public void setIngresoAGranja(LocalDate ingresoAGranja) {
		this.fechaIngresoAGranja = ingresoAGranja;
	}
	
	public int getDiasExpiracion() {
		if(tiposAnimales==null) {
			return 0;
		}else
        return tiposAnimales.getDiasExpiracion();
	}

	
	protected double getPrecioCompra(){
		if(tiposAnimales== null) {
			return 0;
		}else
        return tiposAnimales.getPrecioCompra();
	}
	
	protected double getPrecioVenta(){
		if(tiposAnimales== null) {
			return 0;
		}else
        return tiposAnimales.getPrecioVenta();
	}
	public int getCantidadMaxima() {
		if(tiposAnimales== null) {
			return 0;
		}else
        return tiposAnimales.getCantidadMaxima();
	}
	
	public void reproducir(LocalDate i) {
	}
	
	public int getTiempoDeReproduccion() {
		if(tiposAnimales==null) {
			return 0;
		}else
		return tiposAnimales.getTiempoDeReproduccion();
	}

	public int getEdadActual() {
		return edadActual;
	}
	
	public String getAnimal() {
		if(tiposAnimales== null) {
			return null;
		}else
		return tiposAnimales.getAnimal();
	}
	
	
/*	public void comprar(Ganado tipoGanado, int edad) {
		this.precioCompra = setPrecioCompraByAnimal();
	}
	
	public void vender(Ganado tipoGanado,int edad) {
		this.precioVenta= tipoGanado.setPrecioVentaByAnimal();
		
		//String cant = "10";
		//BigDecimal totalVenta = precioVenta.multiply(new BigDecimal(cant));
		//System.out.println("El total de la venta es de "+ totalVenta);
	}
*/
	public double setPrecioVentaByTipoAnimal() {
		return tiposAnimales.getPrecioVenta();
	}
	
	public double setPrecioCompraByTipoAnimal() {
		return tiposAnimales.getPrecioCompra();
	}
	
	public TiposAnimales getTiposAnimales() {
		return tiposAnimales;
	}

	public void setTiposAnimales(TiposAnimales tiposAnimales) {
		this.tiposAnimales = tiposAnimales;
	}

	@Override
	public String toString() {
		return String.format("Animal " +" " + getAnimal()  
				+ " . Tiempo de Reproduccion: " + getTiempoDeReproduccion() + ". Precios de compra y venta: " + precioCompra + " " + precioVenta + ". CantidadMaxima: " + getCantidadMaxima() + "\n");
	}

	
	public void agregar(int tipo, int diasEdad, LocalDate i){
		new Animal(tipo, diasEdad, i); 
	}
	
}