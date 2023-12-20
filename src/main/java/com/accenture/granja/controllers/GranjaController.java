package com.accenture.granja.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.granja.model.Granja;
import com.accenture.granja.services.GranjaService;

@RestController
public class GranjaController {

	
	private GranjaService granjaService;
	
	@Autowired
	public GranjaController(GranjaService granjaService) {

	       this.granjaService = granjaService;

	   }

	  @GetMapping("/granja")
	   public List<Granja> getGranjas() {

	            // Aca se instancia al Servicio donde esta la logica central
	       return granjaService.obtenerTodasLasGranjas();

	   }

	}
