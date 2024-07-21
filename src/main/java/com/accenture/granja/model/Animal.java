package com.accenture.granja.model;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.accenture.granja.exceptions.NoContentException;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Entity
@Data
public class Animal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "granja_id")
	public Granja granja;
	
	@ManyToOne(fetch = FetchType.EAGER)
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


	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	public LocalDate fechaIngresoAGranja;
	public int edadEnDiasAlIngresar;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	public LocalDate nacimiento;// calcula ingreso-edad
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	public LocalDate fechaExpiracion; //nacimiento + expiracion por tipoAnimal

	//public int edadActual;
	public double precioCompra;// Se setean al momento de la transaccion correspondiente
	public double precioVenta; // Se setean al momento de la transaccion correspondiente
	
	public Animal() {
		
	}

	public Animal(Long tipos_animal_id,  int edadEnDiasAlIngresar, LocalDate fechaIngresoAGranja) {
		this.tiposAnimales= getAnimalById(tipos_animal_id);
		this.fechaIngresoAGranja = fechaIngresoAGranja;
		this.edadEnDiasAlIngresar = edadEnDiasAlIngresar;
		LocalDate fechaNacimiento = fechaIngresoAGranja.minusDays(edadEnDiasAlIngresar); 
		setNacimiento(fechaNacimiento);
		LocalDate fechaExpiracion = fechaNacimiento.plusDays(getDiasExpiracionByTipo());
		setFechaExpiracion(fechaExpiracion);
		System.out.println(fechaExpiracion);
	}

	public int getEdadActual() { 
		int edad = (int)ChronoUnit.DAYS.between(getNacimiento(), LocalDate.now());
		return edad;
	}

	public LocalDate getNacimiento() {
		return fechaIngresoAGranja.minusDays(edadEnDiasAlIngresar);
	}

	public LocalDate getFechaExpiracion() {
		return getNacimiento().plusDays(getTiposAnimales().getDiasExpiracion());
	}

	

	public void reproducir() {
		LocalDate i = granja.getUltimaActualizacion();
		while( i.isBefore(LocalDate.now())) {
				if( i.isBefore(getFechaExpiracion())) {
					System.out.println("Fecha de reproduccion: " + i);
					agregar(getTiposAnimales().getId(), 0, i);
					 i.plusDays(getTiposAnimales().getTiempoDeReproduccion());
				}
				else {
					//System.out.println("Hay que eliminar Animal id " + getId());
					//eliminar(getId());
				}
				System.out.println("La ultima fecha de Actualizacion es: " + granja.getUltimaActualizacion());
		}
		System.out.println("Se actualizo Granja exitosamente a la fecha " + granja.getUltimaActualizacion() );
	}
	

	
/*	public int getEdadActual() {
		return LocalDate.now().compareTo(this.getNacimiento());
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
	

	public TiposAnimales getAnimalById(Long id) {
		return tiposAnimales;
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
	
	public int getDiasExpiracionByTipo() {
		if(tiposAnimales== null) {
			throw new NoContentException("El tipo no existe");
		}else
		return tiposAnimales.getDiasExpiracion();
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
		return String.format("Animal " +" " + getTiposAnimales().getAnimal()  
				+ " . Tiempo de Reproduccion: " + getTiposAnimales().getTiempoDeReproduccion() + ". Precios de compra y venta: " + precioCompra + " " + precioVenta + ". CantidadMaxima: " + getTiposAnimales().getCantidadMaxima() + "\n");
	}

	
	public void agregar(Long tipo, int diasEdad, LocalDate i){
		new Animal(tipo, diasEdad, i); 
	}

	
	
}