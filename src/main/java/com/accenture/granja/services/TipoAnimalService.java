package com.accenture.granja.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.accenture.granja.model.TiposAnimales;
import com.accenture.granja.repository.TipoAnimalRepository;


@Service
public class TipoAnimalService {


	// Aca se instancia al repositorio, es la capa final ya que se consulta a la base de datos

	@Autowired
	private TipoAnimalRepository tiposAnimalesRepository;

	public List<TiposAnimales> obtenerTodosLosTiposAnimales() {  
		return tiposAnimalesRepository.findAll();
	}    

	public TiposAnimales getById(long tipoAnimalId) {
		return tiposAnimalesRepository.findById(tipoAnimalId)
				.orElseThrow(() -> new RuntimeException("Tipo de animal no encontrado con ID: " + tipoAnimalId));
	}

	public void agregarTipo(TiposAnimales tipo) {
		tiposAnimalesRepository.save(tipo);
	}

	public void editarTipo(TiposAnimales tipo) {
		tiposAnimalesRepository.save(tipo);		
	}

	public void eliminarTipo(Long id) {
		tiposAnimalesRepository.deleteById(id);
	}


}
