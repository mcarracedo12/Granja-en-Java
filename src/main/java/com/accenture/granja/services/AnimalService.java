package com.accenture.granja.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.granja.model.Animal;
import com.accenture.granja.model.Compra;
import com.accenture.granja.model.TiposAnimales;
import com.accenture.granja.repository.AnimalRepository;
import com.accenture.granja.repository.CompraRepository;
import com.accenture.granja.repository.TipoAnimalRepository;
@Service
@Transactional
public class AnimalService {
	
	@Autowired
	private AnimalRepository animalRepo;
	@Autowired
	private CompraRepository compraRepo;
	@Autowired
	private TipoAnimalRepository tiposRepo;


	// ANIMALES
	
	public List<Animal> obtenerTodosLosAnimales() {
		// Aca se instancia al repositorio, es la capa final ya que se consulta a la base de datos
		return animalRepo.findAll();
	}
	
	public List<Animal> getAnimalByTipoId(Long tipos_animal_id) {
		return animalRepo.findByTiposAnimales_id(tipos_animal_id);
	}

	public Animal getAnimalById(Long id) {
		Animal animal= animalRepo.findById(id).orElse(null);
		return animal;
	}

	public void agregarAnimal(Animal animal) {
		animalRepo.save(animal);
	}
	
	public void agregarAnimal(Animal animal, Long tipoId) {
		  Optional<TiposAnimales> ta = tiposRepo.findById(tipoId);
		  animal.setTiposAnimales(ta.get());
		  agregarAnimal(animal);
	}
	
	public void asignarCompra(Animal animal, Long compraId) {
		  Optional<Compra> compra = compraRepo.findById(compraId);
		  animal.setCompra(compra.get());
		  animal.setPrecioCompra();
		  //editarAnimal(animal);
	}
	
	public void editarAnimal(Animal animal) {
		animalRepo.save(animal);
	}

	public void eliminarAnimal(Long id) {
		animalRepo.deleteById(id);
	}

// FIN ANIMALES
	
}
