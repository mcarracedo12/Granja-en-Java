package com.accenture.granja.controllers;

import java.util.List;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.granja.model.Granja;
import com.accenture.granja.services.GeneralService;


@RestController
@CrossOrigin(origins = "http://localhost:4200") 
public class GranjaController {

	@Autowired
	private GeneralService service;

	// Aca se instancia al Servicio donde esta la logica central


	@GetMapping("/granja")
	@ResponseBody
	public Granja getGranja() {
		Granja granja = service.buscarGranja((long)1);
		return granja;				
	}

	@GetMapping("/granjas")
	@ResponseBody
	public List<Granja> getGranjas() {
		List<Granja> granjas = service.buscarGranjas();
		return granjas;				
	}



	@GetMapping("/granjas/{id}")
	public ResponseEntity<Granja> getGranjaDetails(@PathVariable Long id) {
		Granja granja = service.buscarGranja(id);
		 if (granja != null) {
	            return ResponseEntity.ok(granja);
	        } else {
	            return ResponseEntity.notFound().build();
	        }		
	}
	
	

	@PostMapping("/granjas")
	public void createGranja(@RequestBody Granja granja) {
		service.agregarGranja(granja); // la granja no necesita tener ID para el POST
	}

	@PutMapping("/granjas/{id}")
	public void updateGranja(@RequestBody Granja granja, @PathVariable Long id) {
		service.editarGranja(granja); //  la granja SI necesita tener el ID para el PUT
	}

	@DeleteMapping("/granjas/{id}")
	public void deleteGranja(@PathVariable Long id) {
		service.eliminarGranja(id); // 
	}

}
