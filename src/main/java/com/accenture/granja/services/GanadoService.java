package com.accenture.granja.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.accenture.granja.model.Animal;
import com.accenture.granja.repository.GanadoRepository;
@Service
public class GanadoService {
	private final GanadoRepository ganadoRepository;

	   @Autowired
	   public GanadoService(GanadoRepository ganadoRepository) {

	       this.ganadoRepository = ganadoRepository;

	   }
	   
	   public List<Animal> obtenerTodoElGanado() {

	        // Aca se instancia al repositorio, es la capa final ya que se consulta a la base de datos
	    return ganadoRepository.findAll();

	   }    

	   
}
