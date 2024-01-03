package com.accenture.granja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.granja.model.Granja;

import com.accenture.granja.services.GranjaService;

@RestController
public class GranjaController {

	@Autowired
	private GranjaService granjaService;

	// Aca se instancia al Servicio donde esta la logica central


	@GetMapping("/granja")
	@ResponseBody
	public Granja getGranja() {
		return granjaService.buscarGranja(1);		
	}
	
	
	

}
