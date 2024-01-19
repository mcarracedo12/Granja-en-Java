package com.accenture.granja.model;


import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

//import io.micrometer.core.lang.NonNull;
@Entity
public class Animal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;


	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "granja_id")
	public Granja granja;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
    @JoinColumn(name = "tipos_animal_id")
	public TiposAnimales tiposAnimales;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "compra_id")
	public Compra compra;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "venta_id")
	public Venta venta;

	//@NonNull
	public LocalDate fechaIngresoAGranja;
	//@NonNull
	public int edadEnDiasAlIngresar;
	protected LocalDate nacimiento;// calcula ingreso-edad
	protected LocalDate fechaExpiracion; //nacimiento + expiracion por tipoAnimal
	
	//protected int tiempoDeReproduccion; // lo busca por tipo de animal
	//public int edadActual= getEdadActual();// hoy - nacimiento
	//protected int cantidadMaxima; // Lo busca por tipo de animal 
	public double precioCompra;// Se setean al momento de la transaccion correspondiente
	public double precioVenta; // Se setean al momento de la transaccion correspondiente

	
	//Agrego para que no tire error despues nada mas, no deberia hacer falta
	public Animal() {
		super();
	}

	public Animal(Long tipo_animal_id,  int edadEnDiasAlIngresar, LocalDate fechaIngresoAGranja) {
		//this.id = id;
		this.tiposAnimales= getAnimalById(tipo_animal_id);
		this.fechaIngresoAGranja = fechaIngresoAGranja;
		this.edadEnDiasAlIngresar = edadEnDiasAlIngresar;
		this.nacimiento = getNacimiento();
		this.fechaExpiracion = getFechaExpiracion();
		//this.edadActual = setEdadActual();
		//this.precioCompra= getPrecioCompraByTipo();
		//this.precioVenta= 0;
	}
	
	/*public int setEdadActual() {
		int edad= LocalDate.now().compareTo(this.getNacimiento());
		return edad;
	}
*/
	public long getId() {
		return id;
	}

	public LocalDate getNacimiento() {
		return fechaIngresoAGranja.minusDays(edadEnDiasAlIngresar);
	}

	public LocalDate getFechaIngresoAGranja() {
		return fechaIngresoAGranja;
	}

	public void setFechaIngresoAGranja(LocalDate fechaIngresoAGranja) {
		this.fechaIngresoAGranja = fechaIngresoAGranja;
	}
	
	public LocalDate getFechaExpiracion() {
		return getNacimiento().plusDays(getDiasExpiracionByTipo());
	}



	
	
	public void reproducir(LocalDate i) {
	}
	
	public int getTiempoDeReproduccionByTipo() {
		if(tiposAnimales==null) {
			return 0;
		}else
		return tiposAnimales.getTiempoDeReproduccion();
	}
	
/*	public int getEdadActual() {
		return LocalDate.now().compareTo(this.getNacimiento());
	}
	*/
	public TiposAnimales getAnimalById(Long id) {
		return tiposAnimales;
	}
	
	public String getAnimalByTipo() {
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
	public double setPrecioVentaByTipo() {
		if(tiposAnimales== null) {
			return 0;
		}else
		return tiposAnimales.getPrecioVenta();
	}
	
	public double setPrecioCompraByTipo() {
		if(tiposAnimales== null) {
			return 0;
		}else
		return tiposAnimales.getPrecioCompra();
	}
	
	public TiposAnimales getTiposAnimales() {
		if(tiposAnimales== null) {
			return null;
		}else
		return tiposAnimales;
	}

	public void setTiposAnimales(TiposAnimales tiposAnimales) {
		if(tiposAnimales!= null) {	
		this.tiposAnimales = tiposAnimales;
		}
	}
	

	

	public int getDiasExpiracionByTipo() {
		if(tiposAnimales== null) {
			return 0;
		}else
		return tiposAnimales.getDiasExpiracion();
	}
	
	public int getCantidadMaximaByTipo() {
		if(tiposAnimales== null) {
			return 0;
		}else
		return tiposAnimales.getCantidadMaxima();
	}
	

	public double getPrecioCompraByTipo() {
		if(tiposAnimales== null) {
			return 0;
		}else
		return tiposAnimales.getPrecioCompra();
	}

	public void setPrecioCompra() {
		if(tiposAnimales!= null) {
			this.precioCompra = tiposAnimales.getPrecioCompra(); // no funciona
		}		
	}

	public double getPrecioVentaByTipo() {
		if(tiposAnimales== null) {
			return 0;
		}else
		return tiposAnimales.getPrecioVenta();
	}

	public void setPrecioVenta() {
		if(tiposAnimales!= null) {
			this.precioVenta = tiposAnimales.getPrecioVenta();
		}
		
	}
	

	@Override
	public String toString() {
		return String.format("Animal " +" " + getAnimalByTipo()  
				+ " . Tiempo de Reproduccion: " + getTiempoDeReproduccionByTipo() + ". Precios de compra y venta: " + precioCompra + " " + precioVenta + ". CantidadMaxima: " + getCantidadMaximaByTipo() + "\n");
	}

	
	public void agregar(Long tipo, int diasEdad, LocalDate i){
		new Animal(tipo, diasEdad, i); 
	}
	
}