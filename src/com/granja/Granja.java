package com.granja;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class Granja {

	private BigDecimal dineroEnCaja;
	private ArrayList<Huevo> huevos = new ArrayList<Huevo>();
	private ArrayList<Pollito> pollitos = new ArrayList<Pollito>();
	private ArrayList<TiposAnimales> tiposAnimales = new ArrayList<>();

	private LocalDate now = LocalDate.now();

	public Granja(BigDecimal dineroEnCaja, int cantMaxPollitos, int cantMaxHuevos) {
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


	public void addHuevo(Huevo huevo) {
		this.huevos.add(huevo);
	}

	public void addTiposAnimales(TiposAnimales tiposAnimales) {
		this.tiposAnimales.add(tiposAnimales);
	}

	public void venderPollito(int cant) {
		if (pollitos.size() > cant) {
			System.out.println("Voy a Comprar pollis");
		}
	}

	public void comprarPollito() {}

	public void venderHuevos() {

	}

	public void comprarHuevos(int cant) {
		// private BigDecimal montoTotal =
		// TiposAnimales.getPrecioCompraByAnimal("huevos") * cant;

		// if(dineroEnCaja>(Precios.getPrecioCompraByAnimal("huevos")*cant)) {

		// }
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

	public void eliminarExpirados(ArrayList<Pollito> ganado) {
		Iterator<Pollito> iterator = ganado.iterator();
		while (iterator.hasNext()) {
			if (now.isAfter((iterator.next().fechaExpiracion))) {
				iterator.remove();
			}
		}
		System.out.println(ganado);
	}

	public ArrayList<TiposAnimales> getTiposAnimales() {
		return tiposAnimales;
	}

	public void setTiposAnimales(ArrayList<TiposAnimales> tiposAnimales) {
		this.tiposAnimales = tiposAnimales;
	}

	public void actualizar() {
		System.out.println(
				"Actualizar granja no funciona aun Quiero que Eliminar expirados me funcione con todo el ganado");
		// eliminarExpirados(huevos);
		eliminarExpirados(pollitos);


	}

}
