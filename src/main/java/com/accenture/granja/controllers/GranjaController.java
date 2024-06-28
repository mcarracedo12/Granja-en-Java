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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.granja.model.Animal;
import com.accenture.granja.model.Granja;
import com.accenture.granja.model.TiposAnimales;
import com.accenture.granja.services.AnimalService;
import com.accenture.granja.services.CompraService;
import com.accenture.granja.services.GeneralService;
import com.accenture.granja.services.GranjaService;
import com.accenture.granja.services.TiposService;
import com.accenture.granja.services.VentaService;

@RestController
@RequestMapping("/granja")
@CrossOrigin(origins = "http://localhost:4200") 
public class GranjaController {

	@Autowired
	private GranjaService granjaService;
	@Autowired
	private TiposService tiposService;
	@Autowired
	private AnimalService animalService;
	@Autowired
	private CompraService compraService;
	@Autowired
	private VentaService ventaService;

	
	// INICIO GRANJAS
	
	@GetMapping("/")
	@ResponseBody
	public List<Granja> getGranjas() {
		List<Granja> granjas = granjaService.buscarGranjas();
		return granjas;				
	}

	@GetMapping("/{id}")
	public ResponseEntity<Granja> getGranjaDetails(@PathVariable Long id) {
		Granja granja = granjaService.buscarGranja(id);
		 if (granja != null) {
	            return ResponseEntity.ok(granja);
	        } else {
	            return ResponseEntity.notFound().build();
	        }		
	}

	@PostMapping("/")
	public void createGranja(@RequestBody Granja granja) {
		granjaService.agregarGranja(granja); // la granja no necesita tener ID para el POST
	}

	@PutMapping("/{id}")
	public void updateGranja(@RequestBody Granja granja, @PathVariable Long id) {
		granjaService.editarGranja(granja); //  la granja SI necesita tener el ID para el PUT
	}

	@DeleteMapping("/{id}")
	public void deleteGranja(@PathVariable Long id) {
		granjaService.eliminarGranja(id); // 
	}

	//FIN GRANJA
	
	//INICIO TIPO

	@GetMapping("/{granja_id}/tipos")
	public List<TiposAnimales> getTiposAnimales() {
	List<TiposAnimales> tipos= tiposService.obtenerTodosLosTiposAnimales();
		return tipos;
	}
	

	@GetMapping("/tipos/{id}")
	public TiposAnimales getTipoDetails(@PathVariable Long id) {
		TiposAnimales tipo = tiposService.getTipoById(id);
        return tipo;	 
	}
	
	

	@GetMapping("/granjas/{granja_id}/tipos")
	public List<TiposAnimales> getTiposAnimales(@PathVariable Long granja_id) {
	List<TiposAnimales> tipos= tiposService.obtenerTodosLosTiposAnimalesByGranja(granja_id);
		return tipos;

	}


	@GetMapping("/granjas/{granja_id}/tipos/{id}")
	public ResponseEntity<TiposAnimales> getTipoDetails(@PathVariable Long id, @PathVariable Long granja_id ) {
		TiposAnimales tipo = tiposService.getByGranjaIdAndId(id, granja_id);
        if (tipo != null) {
            return ResponseEntity.ok(tipo);
        } else {
            return ResponseEntity.notFound().build();
        }	 
  
	}
	
	 @GetMapping("/granjas/{granja_id}/tipos/{tipo_id}/animales")
		public List<Animal> getAnimalDetails(@PathVariable Long tipo_id, @PathVariable Long granja_id ) {
			List<Animal>  animales;
			TiposAnimales tipo = tiposService.getByGranjaIdAndId(tipo_id, granja_id);
			animales = ResponseEntity.ok(tipo).getBody().animales;
	            return animales;
	        
	}
	
	
/*
	@PostMapping("/granjas/{granja_id}/tipos")
	public void createTipoAnimal(@RequestBody TiposAnimales tipo, @PathVariable Long granja_id) {
		try {
			tipoAnimalService.agregarTipo(tipo); //no necesita tener ID para el POST
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	*/

	@PostMapping("/tipos")
	public void createTipoAnimal(@RequestBody TiposAnimales tipo) {
		try {
			tiposService.agregarTipo(tipo); //no necesita tener ID para el POST
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@PutMapping("/tipos/{id}")
	public void updateTipos(@RequestBody TiposAnimales tipo, @PathVariable Long id) {
		tiposService.editarTipo(tipo); //   SI necesita tener el ID para el PUT
	}

	@DeleteMapping("tipos/{id}")
	public void deleteTipo(@PathVariable Long id) {
		tiposService.eliminarTipo(id);
	}
	
	//FIN TIPO
	
	
	
}
