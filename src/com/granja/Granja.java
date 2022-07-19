package com.granja;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Granja {


	private BigDecimal dineroEnCaja;
	int cantMaxPollitos;
	int cantMaxHuevos;
	private ArrayList<Huevo> huevos = new ArrayList<>();
	private ArrayList<Pollito> pollitos = new ArrayList<>();
	private int cantHuevos = huevos.size();
	private int cantPollitos = pollitos.size();

	public Granja(String dineroEnCaja, int cantMaxPollitos, int cantMaxHuevos) {
		super();
		this.dineroEnCaja = new BigDecimal(dineroEnCaja);
		this.cantMaxHuevos = cantMaxHuevos;
		this.cantMaxPollitos = cantMaxPollitos;
	}

	public int getCantMaxPollitos() {
		return cantMaxPollitos;
	}

	public void setCantMaxPollitos(int cantMaxPollitos) {
		this.cantMaxPollitos = cantMaxPollitos;
	}

	public int getCantMaxHuevos() {
		return cantMaxHuevos;
	}

	public void setCantMaxHuevos(int cantMaxHuevos) {
		this.cantMaxHuevos = cantMaxHuevos;
	}

	public int getCantHuevos() {
		return cantHuevos;
	}

	public void setCantHuevos(int cantHuevos) {
		this.cantHuevos = cantHuevos;
	}

	public int getCantPollitos() {
		return cantPollitos;
	}

	public void setCantPollitos(int cantPollitos) {
		this.cantPollitos = cantPollitos;
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

	public void venderPollito(int id) {
	}

	public void comprarPollito() {}

	public void venderHuevos(int id) {
	}

	public void comprarHuevos() {}

	public void mostrarEstado() {

		System.out.println("La cantidad de huevos que hay en la granja es de " + huevos.size());
		System.out.println("La mayor cantidad de huevos que puede haber es de: " + cantMaxHuevos);
		System.out.println("La cantidad de pollitos que hay en la granja es de " + pollitos.size());
		System.out.println("La mayor cantidad de pollitos que puede haber es de: " + cantMaxPollitos);
		System.out.println("La caja es de " + this.dineroEnCaja + " pesos");

	}

	public static void ofrecerMenu() {
		System.out.println("\n\tIngrese una opcion del menu: ");
		System.out.println("1. Mostrar estado de la granja");
		System.out.println("2. Comprar huevos");
		System.out.println("3. Vender huevos");
		System.out.println("4. Comprar pollitos");
		System.out.println("5. Vender pollitos");
		System.out.println("6. Salir \n");
	}



	@Override
	public String toString() {
		return String.format("huevos %s - cantHuevos %d - pollitos %s - cantPollitos %d - dineroEnCaja %s", huevos,
				huevos.size(), pollitos, pollitos.size(),
				dineroEnCaja);
	}



}