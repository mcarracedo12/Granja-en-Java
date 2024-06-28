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
import com.accenture.granja.services.GeneralService;

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

	@GetMapping("/tipos/{tiposAnimales_id}/animales")
	public List<Animal> getAnimalesByTipo(@PathVariable Long tiposAnimales_id) {
		return animalService.getAnimalByTipoId(tiposAnimales_id);

	}

	@GetMapping("/animales/{id}")
	public ResponseEntity<Animal> getAnimalById(@PathVariable Long id) {
		Animal animal = animalService.getAnimalById(id);
		return ResponseEntity.ok(animal);
	}

	@PostMapping("/tipos/{tiposAnimales_id}/animales/{cantidad}")
	public void createAnimal(@PathVariable Long tiposAnimales_id, @PathVariable Long cantidad,
			@RequestBody Animal animal) {
		for (int cant = 0; cant < cantidad; cant++) {
			animalService.agregarAnimal(animal, tiposAnimales_id);
		}
	}

	@PostMapping("/tipos/{tiposAnimales_id}/animales")
	public void createAnimal(@PathVariable Long tiposAnimales_id, @RequestBody Animal animal) {
		animalService.agregarAnimal(animal, tiposAnimales_id);
	}

	@PutMapping("/animales/{id}")
	public void updateAnimal(@RequestBody Animal animal, @PathVariable Long id) {
		animalService.editarAnimal(animal); // SI necesita tener el ID para el PUT
	}

	@DeleteMapping("/animales/{id}")
	public void deleteAnimal(@PathVariable Long id) {
		animalService.eliminarAnimal(id);
	}

}
