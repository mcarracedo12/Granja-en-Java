package com.accenture.granja.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
		Granja granja = granjaService.buscarGranja(1);
		return granja;				
	}
	
	@GetMapping("/granjas")
	@ResponseBody
	public List<Granja> getGranjas() {
		List<Granja> granjas = granjaService.buscarGranjas();
		return granjas;				
	}
	
	@GetMapping("/granjas/{id}")
	public Granja getGranjaDetails(@PathVariable int id) {
		Granja granja = granjaService.buscarGranja(id);
		return granja;		
	}
	
	
	@PostMapping("/granjas")
	public void createGranja(@RequestBody Granja granja) {
		granjaService.agregarGranja(granja);
	}

}
