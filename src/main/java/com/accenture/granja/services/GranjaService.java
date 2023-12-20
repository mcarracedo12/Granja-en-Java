package com.accenture.granja.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.granja.model.Granja;
import com.accenture.granja.repository.GranjaRepository;


@Service
public class GranjaService {
	private final GranjaRepository granjaRepository;

	   @Autowired
	   public GranjaService(GranjaRepository granjaRepository) {

	       this.granjaRepository = granjaRepository;

	   }
	   
	   public List<Granja> obtenerTodasLasGranjas() {

	        // Aca se instancia al repositorio, es la capa final ya que se consulta a la base de datos
	    return granjaRepository.findAll();

	   }    

	   
}
