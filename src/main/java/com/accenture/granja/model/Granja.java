package com.accenture.granja.model;


import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
public class Granja {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double dineroEnCaja;
	private String nombre;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	private LocalDate ultimaActualizacion;
	@OneToMany(mappedBy = "granja", cascade = CascadeType.ALL, orphanRemoval = true)
	//@JsonIgnore
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
	
	@OneToMany(mappedBy = "granja", cascade = CascadeType.ALL, orphanRemoval = true)
	//@JsonIgnore
	public List<Usuario> usuarios;




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
	

	
}