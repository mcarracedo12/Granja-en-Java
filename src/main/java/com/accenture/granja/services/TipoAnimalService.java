package com.accenture.granja.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.accenture.granja.model.TiposAnimales;
import com.accenture.granja.repository.TipoAnimalRepository;


@Service
public class TipoAnimalService {
	private final TipoAnimalRepository tipoAnimalRepository;

	   @Autowired
	   public TipoAnimalService(TipoAnimalRepository tipoAnimalRepository) {

	       this.tipoAnimalRepository = tipoAnimalRepository;

	   }
	   
	   public List<TiposAnimales> obtenerTodosLosTiposAnimales() {

	        // Aca se instancia al repositorio, es la capa final ya que se consulta a la base de datos
	    return tipoAnimalRepository.findAll();

	   }    

	   
}
