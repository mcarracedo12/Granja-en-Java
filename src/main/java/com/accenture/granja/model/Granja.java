package com.accenture.granja.model;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;




/*class EdadComparator implements Comparator<Ganado> {
	@Override
	public int compare(Ganado value1, Ganado value2) {
		return 1;
		// return Integer.compare(value1.getEdadActual(), value2.getEdadActual());
	}
}
*/ //Quiero que la lista de animales este ordenada por edad
@Entity
public class Granja {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private double dineroEnCaja;
	private String nombre;
	private LocalDate ultimaActualizacion = LocalDate.now().minusDays(20);
	@OneToMany(mappedBy = "granja", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	public List<TiposAnimales> tiposAnimales;
	@OneToMany(mappedBy = "granja", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	public List<Animal> animales;
	@OneToMany(mappedBy = "granja", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	public List<Compra> compras;
	@OneToMany(mappedBy = "granja", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore  //Me muestra las transacciones en el get de la granja si lo comento
	public List<Venta> ventas;
	
	//Agrego para que no tire error despues nada mas, no deberia hacer falta
	public Granja() {
		super();		
	}
	
	public Granja(double cajita) {
		super();
		this.dineroEnCaja = cajita;
	}

	public double getDineroEnCaja() {
		return dineroEnCaja;
	}

	public void setDineroEnCaja(double dineroEnCaja) {
		this.dineroEnCaja = dineroEnCaja;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getUltimaActualizacion() {
		return ultimaActualizacion;
	}

	public void setUltimaActualizacion(LocalDate ultimaActualizacion) {
		this.ultimaActualizacion = ultimaActualizacion;
	}
	
	public void comprarPollitos(int cant) {
		List<Animal>pollitos = this.getAnimalesByTipo(2);
		
		for(int i =0; i< cant; i++ ) {
				
			try (Scanner scanner = new Scanner(System.in)) {
				System.out.println("Ingrese cantidad de dias de vida actual de los pollitos");	
					int dias = scanner.nextInt();
					System.out.println("llega aca 2");
					
					
					
					
					System.out.println("Cantidad de pollitos actual: " + pollitos.size());
					
					//pollitos.add(new Pollito(2,dias,LocalDate.now()) );
					//System.out.println(pollitos);
					System.out.println("llega aca 2 1/5");
					//Pollito pollo= new Pollito((long)2,dias,LocalDate.now());
					//pollitos.add(pollo);
					System.out.println("llega aca 3 ");
			}
			System.out.println("Compra terminada ");
			System.out.println("llega aca 4 ");
				//BigDecimal costoTotal = precio.multiply(cant);
			//	System.out.println("llega aca 4 ");
				//dineroEnCaja= dineroEnCaja.subtract(costoTotal);
			//	System.out.println("llega aca 5 ");
		}
	
		
	}


	//@SuppressWarnings("unchecked")
/*	private List<Animal> getAnimalesByTipoAnimal(int tipoAnimal_id) {
		List<Animal> ganado = (List<Animal>) animales.stream().filter((animal) ->  tipoAnimal_id == animal.getTiposAnimales().getId());
		return ganado;
	}
	*/

	public List<Animal> getAnimalesByTipo(int tipoAnimalId) {
		//return null;
	    return animales.stream()
	            .filter(animal -> tipoAnimalId == animal.getTiposAnimales().getId())
	            .collect(Collectors.toList());
	}

	/*public List<Pollito> getPollitos(Long id) {
		System.out.println("getPollitos no tiene implementacion en Granja");
		return tiposAnimales.getPollitos();

	}
	*/


	/*public void addTiposAnimales(TiposAnimales tipo) {
		tiposAnimales.add(tipo);// solo funciona con list
	}
	*/
	
/*	public void venderPollitos(int cant) {
		if (pollitos.size() >= cant) {
			System.out.println("Voy a Comprar " + cant + " pollitos\n");
		}
		else
			System.out.println("No hay " + cant + " pollos. Hay solo " + pollitos.size());
	}

	public void venderHuevos(int cant) {
		if (huevos.size() >= cant) {
			System.out.println("Hay stock suficiente para vender " + cant + " huevos\n");
		} else
			System.out.println("No hay tantos huevos. Hay solo " + huevos.size() + "\n");

	}

	public void comprarHuevos(int cant) {
		if(9000 < huevos.size()+cant) {
			System.out.println("No puede comprar tantos");
		}
		else
		// private BigDecimal montoTotal =
		// TiposAnimales.getPrecioCompraByAnimal("huevos") * cant;
		// if(dineroEnCaja>(Precios.getPrecioCompraByAnimal("huevos")*cant)) {
		// }
		System.out.println("Dispones de $" + dineroEnCaja + " para comprar huevos");
	}
*/
	public void mostrarEstado() {
		System.out.println("La caja es de " + this.getDineroEnCaja() + " pesos");
		//mostrarAnimales();
		mostrarTiposAnimales();
		System.out.println("Fecha de ultima actualizacion: " + this.getUltimaActualizacion()+"\n\n" );
	}


	

	public void mostrarAnimales() {
		try {
			System.out.println("ANIMALES: " + animales.size()+"\n\n");
			for (Animal animal : animales) {
			System.out.println(animal.toString());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public void mostrarTiposAnimales() {
		try {
			if(tiposAnimales!=null) {
			System.out.println("TIPOS DE ANIMALES: " + tiposAnimales.size()+"\n\n");
			for (TiposAnimales tipo : tiposAnimales) {
			System.out.println(tipo.toString());
			}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	public void addTiposAnimales(TiposAnimales tipo) {
		tipo.agregar(tipo);
	}
	

	@Override
	public String toString() {
		return String.format("DineroEnCaja %d - Ultima Actualizacion %s",
				dineroEnCaja, getUltimaActualizacion());
	}



	// Iterator<Ganado> iterator = huevos.iterator();
/*
	public void eliminarExpirados(LocalDate i) {
		Iterator<Pollito> iteratorP = pollitos.iterator();
		while (iteratorP.hasNext()) {
			if (i.isAfter((iteratorP.next().fechaExpiracion))) {
				iteratorP.remove();
			}
		}
		System.out.println(pollitos);
		Iterator<Huevo> iteratorH = huevos.iterator();
		while (iteratorH.hasNext()) {
			if (i.isAfter((iteratorH.next().fechaExpiracion))) {
				iteratorH.remove();
			}
		}
		System.out.println(huevos);
	}
*/
	/*
	public void reproducirHuevosIterator() {
		Iterator<Huevo> iterator = huevos.iterator();
		System.out.println("Inicia Huevo iterator");
		while (iterator.hasNext()) {
			LocalDate i = iterator.next().getNacimiento().plusDays(iterator.next().tiempoDeReproduccion);
			System.out.println(i + "Fecha de inicio");
			while (i.isBefore(now)) {
				while (i.isBefore(iterator.next().fechaExpiracion)) {
					System.out.println("Por nacer Pollito.. \n");
					addPollito(new Pollito(0, 0, i));
					// BORRAR EL HUEVO QUE SE CONVIERTE EN POLLO
					System.out.println("Pollito agregado\n");
					iterator.remove();
					System.out.println("Convierto huevo en pollito en la fecha: " + i);
				}
				i = i.plusDays(iterator.next().tiempoDeReproduccion);
			}
		}
		System.out.println("Se termino de Reproducir Huevos..\n");
		System.out.println("Ahora hay " + pollitos.size() + " pollitos y " + huevos.size() + " huevos. \n");
	}
/*
	public void reproducirHuevos() {
		for (Huevo huevo : huevos) {
			LocalDate i = huevo.getNacimiento().plusDays(huevo.tiempoDeReproduccion);
			while (i.isBefore(now)) {

				if (now.isAfter((huevo.fechaExpiracion))) {
					System.out.println("Convierto huevo en pollito en la fecha: " + i);
					addPollito(new Pollito(0, 0, i));
					huevos = (ArrayList<Huevo>) huevos.stream().filter((h) -> {
						return h != huevo;
					}).collect(Collectors.toList());

					i = i.plusDays(huevo.tiempoDeReproduccion);
				}
			}
		}
		System.out.println("Se termino de Reproducir Huevos..\n");
		System.out.println("Ahora hay " + pollitos.size() + " pollitos y " + huevos.size() + " huevos. \n");
	}

	public void reproducirPollitos() {
		System.out.println("Voy a reproducir pollitos");
		for (Pollito pollito : pollitos) {
			LocalDate i = pollito.getNacimiento().plusDays(pollito.tiempoDeReproduccion);
			while (i.isBefore(now)) {
				System.out.println("Fecha de reproduccion: " + i);
				if (i.isBefore(pollito.fechaExpiracion)) {
					addHuevo(new Huevo(0, 0, i));
				}
				i = i.plusDays(pollito.tiempoDeReproduccion);
			}
		}
		System.out.println("\nSe termino de Reproducir Pollitos..\n");
		System.out.println("Ahora hay " + pollitos.size() + " pollitos y " + huevos.size() + " huevos. \n");
	}
*/

	public void actualizar() {
		System.out.println("Actualizando granja...\n");
	//	reproducirGanado(); Este es el que quiero hacer iterando los dias
		//System.out.println("Reproduciendo pollitos");
		//reproducirPollitos();
		//System.out.println(" Fin Reproduciendo pollitos");
		//System.out.println("Reproduciendo huevos");
		//reproducirHuevos();
		//System.out.println("Fin Reproduciendo huevos");
		// reproducirHuevosIterator();
		//System.out.println("Ahora hay " + pollitos.size() + " pollitos y " + huevos.size() + " huevos. \n");
		//System.out.println("Eliminando Pollitos expirados");
		//eliminarExpirados();
		//System.out.println("Ahora hay " + pollitos.size() + " pollitos y " + huevos.size() + " huevos. \n");
		this.setUltimaActualizacion(LocalDate.now());
	}

	/*private void reproducirGanado() {
		System.out.println("Voy a reproducir Ganado");
		//for(LocalDate i = ultimaActualizacion; i.isBefore(now); i.plusDays(1)) {
		LocalDate i = ultimaActualizacion;
		while( i.isBefore(now)) {
			System.out.println("Fecha de reproduccion: " + i);
			for (Pollito pollito : pollitos) {
				pollito.reproducir(i);
			}
			for (Huevo huevo: huevos) {
				huevo.reproducir(i);
			}
			eliminarExpirados(i);
			 i.plusDays(1);
		}
		System.out.println("La ultima fecha de Actualizacion es: " + ultimaActualizacion);
	}*/

	public long getId() {
		return id;
	}

	
	
	public void addTiposAnimales(String animal, int diasExpiracion, int cantidadMaxima, int tiempoDeReproduccion, double precioCompra, double precioVenta) {
		try {
			TiposAnimales tipo = new TiposAnimales(animal, diasExpiracion, cantidadMaxima, tiempoDeReproduccion, precioCompra, precioVenta);
			tipo.agregar(tipo);
			System.out.println("El animal "+ animal +" ha sido agregado");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public List<TiposAnimales> getTiposAnimales(){
		return tiposAnimales;
	}
	public List<Animal> getAnimales(){
		if(animales==null) {
			return null;
		}
		return animales;
	}

	/*
	public void agregarAnimal(TiposAnimales tipoAnimal_id,  int edad, LocalDate fechaIngreso) {
			List<Animal>animales=((TiposAnimales)this.tiposAnimales).animales;
			animales.add(new Animal(tipoAnimal_id, edad, fechaIngreso));
		
	}
	*/
}