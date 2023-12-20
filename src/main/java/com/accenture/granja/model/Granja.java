package com.accenture.granja.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.OneToMany;




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
	@GeneratedValue
	private long id;
	private BigDecimal dineroEnCaja;
	// Queue<String> queue = new PriorityQueue<>(new StringLengthComparator());
	// public Queue<Huevo> huevos = new PriorityQueue<Huevo>(new EdadComparator());
	//public List<Huevo> huevos = new ArrayList<Huevo>();
	//@OneToMany(mappedBy = "granja", cascade = CascadeType.ALL, orphanRemoval = true)
	//private TiposAnimales[] tiposAnimales;
	
	//[new TiposAnimales(1, "HUEVO", 21, 200000, 20, 40)]
	@OneToMany(mappedBy = "granja", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<TiposAnimales> tiposAnimales = new ArrayList<TiposAnimales>();
	@OneToMany(mappedBy = "granja", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Pollito> pollitos = new ArrayList<Pollito>();
	//public List<TiposAnimales> tiposAnimales = new ArrayList<TiposAnimales>();
 
	private LocalDate now = LocalDate.now();
	private LocalDate ultimaActualizacion = now.minusDays(20);
	public Granja() {
		super();
		this.dineroEnCaja = new BigDecimal(0);
	}

	/*public int getCantHuevos() {
		return huevos.size();
	}

	public int getCantPollitos() {
		return pollitos.size();
	}
*/
	public BigDecimal getDineroEnCaja() {
		return dineroEnCaja;
	}

	public void setDineroEnCaja(BigDecimal dineroEnCaja) {
		this.dineroEnCaja = dineroEnCaja;
	}



	/*public void addPollito(Pollito pollito) {
		this.pollitos.add(pollito);
	}


	public void addPollito() {
		pollitos.add(new Pollito(1, 0, now));
	}


	public void addHuevo(Huevo huevo) {
		this.huevos.add(huevo);
	}

	public void addHuevo() {
		huevos.add(new Huevo(1, 0, now));
	}
*/
	public void addTiposAnimales(TiposAnimales tipo) {
		//tiposAnimales.add(tipo);// solo funciona con list
		
	}

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
		System.out.println("La caja es de " + this.dineroEnCaja + " pesos");
		mostrarStock();
		//System.out.println("DETALLE DE HUEVOS: " + huevos);
		//System.out.println("DETALLE DE POLLITOS: " + pollitos);
		mostrarTiposAnimales();
	}


	private void mostrarStock() {
		System.out.println("STOCK: ");
	//	System.out.println("La cantidad de huevos: " + huevos.size());
	//	System.out.println("La cantidad de pollitos: " + pollitos.size());
		//System.out.println("La cantidad de tipos de Animales: " + tiposAnimales.size());
		
	//	System.out.println("La cantidad de tipos de Animales: " + tiposAnimales.length);
		
	}

	private void mostrarTiposAnimales() {
		System.out.println("TIPOS DE ANIMALES:");
		//for (TiposAnimales animal : tiposAnimales) {
		//	animal.toString();
		//}	
		//System.out.println(tiposAnimales);
	}

	public void ofrecerMenu() {
		System.out.println("\n\tIngrese una opcion del menu: ");
		System.out.println("1. Mostrar estado de la granja");
		System.out.println("2. Comprar huevos");
		System.out.println("3. Vender huevos");
		System.out.println("4. Comprar pollitos");
		System.out.println("5. Vender pollitos");
		System.out.println("6. Actualizar granja");
		System.out.println("7. Salir \n");
	}

	@Override
	public String toString() {
		return String.format(
				// "Huevos %s - CantHuevos %d - Pollitos %s - CantPollitos %d  - "
				// + "tiposAnimales %s - CantidadtiposAnimales %d "
				  "- DineroEnCaja %s - Precios %s - Ultima Actualizacion %s",
				//huevos, huevos.size(), pollitos, pollitos.size(),
				//tiposAnimales, tiposAnimales.size(),
				// tiposAnimales, tiposAnimales.length,
				dineroEnCaja, tiposAnimales, getUltimaActualizacion());
	}


/*	public List<TiposAnimales> getTiposAnimales() {
		return tiposAnimales;
	}

	public void setTiposAnimales(ArrayList<TiposAnimales> tiposAnimales) {
		this.tiposAnimales = tiposAnimales;
	}
*/
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
		this.setUltimaActualizacion(now);
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

	public LocalDate getUltimaActualizacion() {
		return ultimaActualizacion;
	}

	public void setUltimaActualizacion(LocalDate ultimaActualizacion) {
		this.ultimaActualizacion = ultimaActualizacion;
	}

}