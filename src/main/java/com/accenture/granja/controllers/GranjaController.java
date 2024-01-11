package com.accenture.granja.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		Granja granja = granjaService.buscarGranja((long)1);
		return granja;				
	}

	@GetMapping("/granjas")
	@ResponseBody
	public List<Granja> getGranjas() {
		List<Granja> granjas = granjaService.buscarGranjas();
		return granjas;				
	}

	@GetMapping("/granjas/{id}")
	public Granja getGranjaDetails(@PathVariable Long id) {
		Granja granja = granjaService.buscarGranja(id);
		if(granja== null) {
			throw new RuntimeException("Granja not found with id: "+ id);
		}
		return granja;		
	}


	@PostMapping("/granjas")
	public void createGranja(@RequestBody Granja granja) {
		granjaService.agregarGranja(granja); // la granja no necesita tener ID para el POST
	}

	@PutMapping("/granjas/{id}")
	public void updateGranja(@RequestBody Granja granja, @PathVariable Long id) {
		granjaService.editarGranja(granja); //  la granja SI necesita tener el ID para el PUT
	}

	@DeleteMapping("/granjas/{id}")
	public void deleteGranja(@PathVariable Long id) {
		granjaService.eliminarGranja(id); // 
	}

}
