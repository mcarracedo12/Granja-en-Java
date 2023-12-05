package com.accenture.granja.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.granja.model.Huevo;
import com.accenture.granja.repository.HuevoRepository;
@Service
public class HuevoService {
	private final HuevoRepository huevoRepository;

	   @Autowired
	   public HuevoService(HuevoRepository huevoRepository) {

	       this.huevoRepository = huevoRepository;

	   }
	   
	   public List<Huevo> obtenerTodosLosHuevos() {

	        // Aca se instancia al repositorio, es la capa final ya que se consulta a la base de datos
	    return huevoRepository.findAll();

	   }    

	   
}
