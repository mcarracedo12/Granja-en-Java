package com.granja;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class Granja {

	private BigDecimal dineroEnCaja;

	public ArrayList<Huevo> huevos = new ArrayList<Huevo>();
	public ArrayList<Pollito> pollitos = new ArrayList<Pollito>();
	private ArrayList<TiposAnimales> tiposAnimales = new ArrayList<>();

	private LocalDate now = LocalDate.now();

	public Granja(BigDecimal dineroEnCaja) {
		super();
		this.dineroEnCaja = dineroEnCaja;
	}

	public int getCantHuevos() {
		return huevos.size();
	}

	public int getCantPollitos() {
		return pollitos.size();
	}

	public BigDecimal getDineroEnCaja() {
		return dineroEnCaja;
	}

	public void setDineroEnCaja(BigDecimal dineroEnCaja) {
		this.dineroEnCaja = dineroEnCaja;
	}



	public void addPollito(Pollito pollito) {
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

	public void addTiposAnimales(TiposAnimales tiposAnimales) {
		this.tiposAnimales.add(tiposAnimales);
	}

	public void venderPollitos(int cant) {
		if (pollitos.size() >= cant) {
			System.out.println("Voy a Comprar " + cant + " pollitos\n");
		}
		else
			System.out.println("No hay " + cant + " pollos. Hay solo " + pollitos.size());
	}

	public void comprarPollitos(int cant) {
		System.out.println("Dispones de $" + dineroEnCaja + " para comprar pollos");
	}

	public void venderHuevos(int cant) {
		if (huevos.size() >= cant) {
			System.out.println("Hay stock suficiente para vender " + cant + " huevos\n");
		} else
			System.out.println("No hay tantos huevos. Hay solo " + huevos.size() + "\n");

	}

	public void comprarHuevos(int cant) {
		// private BigDecimal montoTotal =
		// TiposAnimales.getPrecioCompraByAnimal("huevos") * cant;
		// if(dineroEnCaja>(Precios.getPrecioCompraByAnimal("huevos")*cant)) {
		// }
		System.out.println("Dispones de $" + dineroEnCaja + " para comprar huevos");
	}

	public void mostrarEstado() {
		System.out.println("La caja es de " + this.dineroEnCaja + " pesos");
		mostrarStock();
		System.out.println("DETALLE DE HUEVOS: " + huevos);
		System.out.println("DETALLE DE POLLITOS: " + pollitos);
		mostrarTiposAnimales();
	}


	private void mostrarStock() {
		System.out.println("STOCK: ");
		System.out.println("La cantidad de huevos: " + huevos.size());
		System.out.println("La cantidad de pollitos: " + pollitos.size());
	}

	private void mostrarTiposAnimales() {
		System.out.println("TIPOS DE ANIMALES:");
		System.out.println(tiposAnimales);
	}

	public static void ofrecerMenu() {
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
		return String.format("Huevos %s - CantHuevos %d - Pollitos %s - CantPollitos %d - DineroEnCaja %s - Precios %s",
				huevos,
				huevos.size(), pollitos, pollitos.size(),
				dineroEnCaja, tiposAnimales);
	}


	// Iterator<Ganado> iterator = huevos.iterator();

	public void eliminarExpirados(ArrayList<Pollito> pollitos) {
		Iterator<Pollito> iterator = pollitos.iterator();
		while (iterator.hasNext()) {
			if (now.isAfter((iterator.next().fechaExpiracion))) {
				iterator.remove();
			}
		}
		System.out.println(pollitos);
	}

	public ArrayList<TiposAnimales> getTiposAnimales() {
		return tiposAnimales;
	}

	public void setTiposAnimales(ArrayList<TiposAnimales> tiposAnimales) {
		this.tiposAnimales = tiposAnimales;
	}

	public void reproducirHuevos() {
		for (Huevo huevo : huevos) {
			LocalDate i = huevo.getNacimiento().plusDays(huevo.tiempoDeReproduccion);
			while (i.isBefore(now)) {
				if (i.isBefore(huevo.fechaExpiracion)) {
					addPollito(new Pollito(0, 0, i));
					// ITERATOR PARA PODER BORRAR EL HUEVO QUE SE CONVIERTE EN POLLO

					// System.out.println("Pollito agregado\n");
					// huevos.stream().filter((h) -> {
					// return h != huevo;
					// }).collect(Collectors.toList());
					// System.out.println("Convierto huevo en pollito en la fecha: " + i);

				}
				i = i.plusDays(huevo.tiempoDeReproduccion);
			}
		}
		System.out.println("Se termino de Reproducir Huevos..\n");
		System.out.println("Ahora hay " + pollitos.size() + " pollitos y " + huevos.size() + " huevos. \n");
	}

	public void reproducirPollitos() {
		System.out.println("Voy a reproducir pollitos");
		for (Pollito pollito : pollitos) {
			LocalDate i = pollito.getNacimiento().plusDays(pollito.tiempoDeReproduccion);
			System.out.println("ln 173 Primer fecha de reproduccion: " + i);
			while (i.isBefore(now)) {
				System.out.println("ln 175 Primer fecha de reproduccion: " + i);
				if (i.isBefore(pollito.fechaExpiracion)) {
					addHuevo(new Huevo(0, 0, i));
					// HACER CON ITERATOR
					System.out.println("ln 177 Fecha de reproduccion: " + i);
					System.out.println("Pollito pone huevo el dia " + i);
					System.out.println("Ahora hay " + huevos.size() + "  huevos: \n" + huevos);
				}
				i = i.plusDays(pollito.tiempoDeReproduccion);
			}
		}
		System.out.println("\nSe termino de Reproducir Pollitos..\n");
		System.out.println("Ahora hay " + pollitos.size() + " pollitos y " + huevos.size() + " huevos. \n");
	}


	public void actualizar() {
		System.out.println("Actualizando granja...\n");
		reproducirHuevos();
		reproducirPollitos();
		eliminarExpirados(pollitos);
		// eliminarExpirados(huevos);
		System.out.println("Ahora hay " + pollitos.size() + " pollitos y " + huevos.size() + " huevos. \n");
	}

}
