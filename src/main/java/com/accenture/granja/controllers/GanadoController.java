package com.accenture.granja.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.granja.model.Ganado;
import com.accenture.granja.services.GanadoService;

@RestController
public class GanadoController {

	private GanadoService ganadoService;
	
	@Autowired
	public GanadoController(GanadoService ganadoService) {

	       this.ganadoService = ganadoService;

	   }

	  @GetMapping("/ganado")
	   public List<Ganado> getGanado() {

	            // Aca se instancia al Servicio donde esta la logica central
	       return ganadoService.obtenerTodoElGanado();

	   }

	}
