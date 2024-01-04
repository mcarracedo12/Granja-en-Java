package com.accenture.granja.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.accenture.granja.model.Animal;
import com.accenture.granja.repository.AnimalRepository;


@Service
public class AnimalService {
	private final AnimalRepository animalRepository;

	   @Autowired
	   public AnimalService(AnimalRepository animalRepository) {
	       this.animalRepository = animalRepository;
	   }
	   
	   public List<Animal> obtenerTodosLosAnimales() {
	        // Aca se instancia al repositorio, es la capa final ya que se consulta a la base de datos
	    return animalRepository.findAll();
	   }    

	   
}
