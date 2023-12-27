package com.accenture.granja.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.granja.model.Huevo;
import com.accenture.granja.services.HuevoService;

@RestController
public class HuevoController {

	private HuevoService huevoService;
	
	@Autowired
	public HuevoController(HuevoService huevoService) {

	       this.huevoService = huevoService;

	   }

	  @GetMapping("/huevos")
	   public List<Huevo> getHuevos() {

	            // Aca se instancia al Servicio donde esta la logica central
	       return huevoService.obtenerTodosLosHuevos();

	   }

	}
