package com.accenture.granja.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.granja.model.Animal;
import com.accenture.granja.services.AnimalService;

@RestController
public class AnimalController {

	private AnimalService animalService;
	
	@Autowired
	public AnimalController(AnimalService animalService) {
	       this.animalService = animalService;
	   }

	  @GetMapping("/animales")
	   public List<Animal> getAnimales() {
	            // Aca se instancia al Servicio donde esta la logica central
	       return animalService.obtenerTodosLosAnimales();

	   }

	}
