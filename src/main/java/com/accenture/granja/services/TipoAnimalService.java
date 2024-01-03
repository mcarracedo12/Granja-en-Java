package com.accenture.granja.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.accenture.granja.model.TiposAnimales;
import com.accenture.granja.repository.TipoAnimalRepository;


@Service
public class TipoAnimalService {
	private final TipoAnimalRepository tiposAnimalesRepository;

	   @Autowired
	   public TipoAnimalService(TipoAnimalRepository tiposAnimalesRepository) {

	       this.tiposAnimalesRepository = tiposAnimalesRepository;

	   }
	   
	   public List<TiposAnimales> obtenerTodosLosTiposAnimales() {

	        // Aca se instancia al repositorio, es la capa final ya que se consulta a la base de datos
	    return tiposAnimalesRepository.findAll();

	   }    
	   
	   public TiposAnimales getById(int tipoAnimalId) {
	        return tiposAnimalesRepository.findById(tipoAnimalId)
	                .orElseThrow(() -> new RuntimeException("Tipo de animal no encontrado con ID: " + tipoAnimalId));
	    }

	   
}
