package com.accenture.granja.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.granja.model.Animal;
import com.accenture.granja.services.AnimalService;

@RestController
@CrossOrigin(origins = "http://localhost:4200") 
public class AnimalController {

	@Autowired
	private AnimalService animalService;

	  @GetMapping("/animales")
	   public List<Animal> getAnimales() {
	            // Aca se instancia al Servicio donde esta la logica central
	       return animalService.obtenerTodosLosAnimales();

	   }
	  
	  @GetMapping("/animales/{id}")
	    public ResponseEntity<Animal> getAnimalById(@PathVariable Long id) {
	        Animal animal = animalService.getById(id);
	        return ResponseEntity.ok(animal);
	    }
	  
	  
	  
	  @PostMapping("/animales")
	  public void createAnimal(@RequestBody Animal animal) {
		  animalService.agregarAnimal(animal);
	  }
	  
		@PutMapping("/animales/{id}")
		public void updateAnimal(@RequestBody Animal animal, @PathVariable Long id) {
			animalService.editarAnimal(animal); //  SI necesita tener el ID para el PUT
		}

		@DeleteMapping("/animales/{id}")
		public void deleteAnimal(@PathVariable Long id) {
			animalService.eliminarAnimal(id); // 
		}

	}
