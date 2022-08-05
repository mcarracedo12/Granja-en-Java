package com.granja;

public class Expiracion {
	private int id;
	private String animal;
	private int cantDias;

	public Expiracion(int id, String animal, int cantDias) {
		super();
		this.id = id;
		this.animal = animal;
		this.cantDias = cantDias;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAnimal() {
		return animal;
	}

	public void setAnimal(String animal) {
		this.animal = animal;
	}

	public int getCantDias() {
		return cantDias;
	}

	public void setCantDias(int cantDias) {
		this.cantDias = cantDias;
	}

	public int getCantDiasByAnimal(String animal) {
		return cantDias;
	}
	@Override
	public String toString() {
		return animal + " " + cantDias;
	}

}