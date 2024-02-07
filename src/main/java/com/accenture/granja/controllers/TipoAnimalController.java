package com.accenture.granja.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.granja.model.TiposAnimales;
import com.accenture.granja.services.TipoAnimalService;

@RestController
public class TipoAnimalController {

	// Aca se instancia al Servicio donde esta la logica central

	@Autowired
	private TipoAnimalService tipoAnimalService;

	@GetMapping("/granjas/{granja_id}/tipos")
	public List<TiposAnimales> getTiposAnimales(@PathVariable Long granja_id) {
		List<TiposAnimales> allTipos = tipoAnimalService.obtenerTodosLosTiposAnimales();
		 /*List<TiposAnimales> tipos = new ArrayList<>();
		    // Filtrar los tipos de animales para la granja específica
		    for (TiposAnimales tipo : allTipos) {
		        if (tipo.getGranjaId()==granja_id) {
		            tipos.add(tipo);
		        }
		    }
		    */
		 // Filtrar los tipos de animales para la granja específica usando Stream API
		    List<TiposAnimales> tipos = allTipos.stream()
		            .filter(tipo -> tipo.getGranjaId()==granja_id)
		            .collect(Collectors.toList());
		    
		return tipos;

	}

	@GetMapping("/granjas/{granja_id}/tipos/{id}")
	public ResponseEntity<TiposAnimales> getTipoAnimalById(@PathVariable Long id, @PathVariable Long granja_id) {
	    List<TiposAnimales> tiposAnimales = tipoAnimalService.obtenerTodosLosTiposAnimales();
	    
	    TiposAnimales tipos = null;
	    try {
			tipos = tiposAnimales.stream().filter(t->t.getId()== id && t.getGranjaId()== granja_id).findFirst().get();
			return ResponseEntity.ok(tipos);
		} catch (Exception e) {
			e.printStackTrace();
			 System.out.println("No se encontro ese tipo");
				return ResponseEntity.notFound().build();
		}
			    
	}
	
	

	@PostMapping("/tipos")
	public void createTipoAnimal(@RequestBody TiposAnimales tipo) {
		tipoAnimalService.agregarTipo(tipo); //no necesita tener ID para el POST
	}

	@PutMapping("/tipos/{id}")
	public void updateTipos(@RequestBody TiposAnimales tipo, @PathVariable Long id) {
		tipoAnimalService.editarTipo(tipo); //   SI necesita tener el ID para el PUT
	}

	@DeleteMapping("tipos/{id}")
	public void deleteTipo(@PathVariable Long id) {
		tipoAnimalService.eliminarTipo(id);
	}


}
