package com.accenture.granja.model;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonIgnore;

//import io.micrometer.core.lang.NonNull;
@Entity
public class Animal {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;


	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "granja_id")
	public Granja granja;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnore
    @JoinColumn(name = "tipos_animal_id")
	public TiposAnimales tiposAnimales;
	
	

	@ManyToOne(fetch = FetchType.EAGER)
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
	public LocalDate nacimiento;// calcula ingreso-edad
	public LocalDate fechaExpiracion; //nacimiento + expiracion por tipoAnimal

	//public int edadActual;
	public double precioCompra;// Se setean al momento de la transaccion correspondiente
	public double precioVenta; // Se setean al momento de la transaccion correspondiente


	
	//Agrego para que no tire error despues nada mas, no deberia hacer falta
	public Animal() {
		super();
	}

	public Animal(Long tipos_animal_id,  int edadEnDiasAlIngresar, LocalDate fechaIngresoAGranja) {
		//this.id = id;
		this.tiposAnimales= getAnimalById(tipos_animal_id);
		this.fechaIngresoAGranja = fechaIngresoAGranja;
		this.edadEnDiasAlIngresar = edadEnDiasAlIngresar;
		this.nacimiento = getNacimiento();
		this.fechaExpiracion = getFechaExpiracion();
	}

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




	public int getEdadActual() { 
		int edad = (int)ChronoUnit.DAYS.between(getNacimiento(), LocalDate.now());
		return edad;
	}



/*	public Venta getVentaById(Long venta_id) {
		return venta;
	}
	*/
	public void setVenta(Venta venta) {
		if(venta!= null) {	
		this.venta = venta;
		}
	}
	
	public Venta getVenta() {
		if(venta== null) {
			return null;
		}else
		return venta;
	}
	
	public Compra getCompra() {
		if(compra== null) {
			return null;
		}else
		return compra;
	}

	public void setCompra(Compra compra) {
		if(compra!= null) {	
		this.compra = compra;
		}
	}



	public void reproducir() {
		LocalDate i = granja.getUltimaActualizacion();
		while( i.isBefore(LocalDate.now())) {
				if( i.isBefore(getFechaExpiracion())) {
					System.out.println("Fecha de reproduccion: " + i);
					agregar(getTipoId(), 0, i);
					 i.plusDays(getTiempoDeReproduccionByTipo());
				}
				else {
					System.out.println("Hay que eliminar Animal id " + getId());
					//eliminar(getId());
				}
				System.out.println("La ultima fecha de Actualizacion es: " + granja.getUltimaActualizacion());
		}
		System.out.println("Se actualizo Granja exitosamente a la fecha " + granja.getUltimaActualizacion() );
	}
	
	
	public int getTiempoDeReproduccionByTipo() {
		if(tiposAnimales==null) {
			return 0;
		}else
		return tiposAnimales.getTiempoDeReproduccion();
	}
	
	public long getTipoId() {
		if(tiposAnimales==null) {
			return 0;
		}else
		return tiposAnimales.getId();
	}
	
	public long getCompraId() {
		if(compra==null) {
			return 0;
		}else
		return compra.getId();
	}
	
	public long getVentaId() {
		if(venta==null) {
			return 0;
		}else
		return venta.getId();
	}
	
	
	
/*	public int getEdadActual() {
		return LocalDate.now().compareTo(this.getNacimiento());
	}
	*/

	

	
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
	
	public TiposAnimales setTiposAnimales(Long tiposAnimales_id) {
		return tiposAnimales;
	}
	
	public TiposAnimales getAnimalById(Long id) {
		return tiposAnimales;
	}
	public String getAnimalByTipo() {
		if(tiposAnimales== null) {
			return null;
		}else
		return tiposAnimales.getAnimal();
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