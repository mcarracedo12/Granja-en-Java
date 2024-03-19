package com.accenture.granja.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.granja.model.Animal;
import com.accenture.granja.model.TiposAnimales;
import com.accenture.granja.services.GeneralService;

@RestController
@CrossOrigin(origins = "http://localhost:4200") 
public class TipoAnimalController {

	// Aca se instancia al Servicio donde esta la logica central

	@Autowired
	private GeneralService service;
	
	@GetMapping("/tipos")
	public List<TiposAnimales> getTiposAnimales() {
	List<TiposAnimales> tipos= service.obtenerTodosLosTiposAnimales();
		return tipos;
	}
	

	@GetMapping("/tipos/{id}")
	public TiposAnimales getTipoDetails(@PathVariable Long id) {
		TiposAnimales tipo = service.getTipoById(id);
        return tipo;	 
  
	}
	
	

	@GetMapping("/granjas/{granja_id}/tipos")
	public List<TiposAnimales> getTiposAnimales(@PathVariable Long granja_id) {
	List<TiposAnimales> tipos= service.obtenerTodosLosTiposAnimalesByGranja(granja_id);
		return tipos;

	}


	@GetMapping("/granjas/{granja_id}/tipos/{id}")
	public ResponseEntity<TiposAnimales> getTipoDetails(@PathVariable Long id, @PathVariable Long granja_id ) {
		TiposAnimales tipo = service.getByGranjaIdAndId(id, granja_id);
        if (tipo != null) {
            return ResponseEntity.ok(tipo);
        } else {
            return ResponseEntity.notFound().build();
        }	 
  
	}
	
	 @GetMapping("/granjas/{granja_id}/tipos/{tipo_id}/animales")
		public List<Animal> getAnimalDetails(@PathVariable Long tipo_id, @PathVariable Long granja_id ) {
			List<Animal>  animales;
			TiposAnimales tipo = service.getByGranjaIdAndId(tipo_id, granja_id);
			animales = ResponseEntity.ok(tipo).getBody().animales;
	            return animales;
	        
	}
	
	
/*
	@PostMapping("/granjas/{granja_id}/tipos")
	public void createTipoAnimal(@RequestBody TiposAnimales tipo, @PathVariable Long granja_id) {
		try {
			tipoAnimalService.agregarTipo(tipo); //no necesita tener ID para el POST
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	*/

	@PostMapping("/tipos")
	public void createTipoAnimal(@RequestBody TiposAnimales tipo) {
		try {
			service.agregarTipo(tipo); //no necesita tener ID para el POST
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	@PutMapping("/tipos/{id}")
	public void updateTipos(@RequestBody TiposAnimales tipo, @PathVariable Long id) {
		service.editarTipo(tipo); //   SI necesita tener el ID para el PUT
	}

	@DeleteMapping("tipos/{id}")
	public void deleteTipo(@PathVariable Long id) {
		service.eliminarTipo(id);
	}


}
