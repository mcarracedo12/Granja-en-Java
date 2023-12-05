package com.accenture.granja.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.granja.model.Pollito;
import com.accenture.granja.repository.PollitoRepository;
@Service
public class PollitoService {
	private final PollitoRepository pollitoRepository;

	   @Autowired
	   public PollitoService(PollitoRepository pollitoRepository) {

	       this.pollitoRepository = pollitoRepository;

	   }
	   
	   public List<Pollito> obtenerTodosLosPollitos() {

	        // Aca se instancia al repositorio, es la capa final ya que se consulta a la base de datos
	    return pollitoRepository.findAll();

	   }    

	   
}
