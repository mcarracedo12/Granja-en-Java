package com.accenture.granja.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.granja.model.Animal;
import com.accenture.granja.model.TiposAnimales;
import com.accenture.granja.services.AnimalService;
import com.accenture.granja.services.TipoAnimalService;

@RestController
public class TipoAnimalController {

	private TipoAnimalService tipoAnimalService;
	
	@Autowired
	public TipoAnimalController(TipoAnimalService tipoAnimalService) {

	       this.tipoAnimalService = tipoAnimalService;

	   }

	  @GetMapping("/tipos")
	   public List<TiposAnimales> getTiposAnimales() {

	            // Aca se instancia al Servicio donde esta la logica central
	       return tipoAnimalService.obtenerTodosLosTiposAnimales();

	   }

	}
