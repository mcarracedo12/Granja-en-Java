package com.accenture.granja.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.granja.model.Pollito;
import com.accenture.granja.services.PollitoService;

@RestController
public class PollitoController {
	
	private PollitoService pollitoService;
	
	@Autowired
	private PollitoController(PollitoService pollitoService) {
		this.pollitoService= pollitoService;
	};
	
	@GetMapping("/pollitos")
	public List<Pollito> getPollitos() {

        // Aca se instancia al Servicio donde esta la logica central
   return pollitoService.obtenerTodosLosPollitos();

}

}
