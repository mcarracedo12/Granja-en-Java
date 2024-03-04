package com.accenture.granja.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.accenture.granja.model.Animal;
import com.accenture.granja.repository.AnimalRepository;

@Service
public class AnimalService {

	@Autowired
	public AnimalRepository animalRepo;


	public List<Animal> obtenerTodosLosAnimales() {
		// Aca se instancia al repositorio, es la capa final ya que se consulta a la base de datos
		return animalRepo.findAll();
	}

	public Animal getById(Long id) {
		Animal animal= animalRepo.findById(id).orElse(null);
		return animal;
	}

	public void agregarAnimal(Animal animal) {
		animalRepo.save(animal);
	}

	public void editarAnimal(Animal animal) {
		animalRepo.save(animal);
	}

	public void eliminarAnimal(Long id) {
		animalRepo.deleteById(id);
	}



}
