package com.accenture.granja.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	public ResponseEntity<List<Granja>> getGranjas() {
		List<Granja> granjas = granjaService.buscarGranjas();
		return new ResponseEntity<>(granjas, HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Granja> getGranjaDetails(@PathVariable Long id) {
		Granja granja = granjaService.buscarGranja(id);
		return new ResponseEntity<>(granja, HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<Granja> createGranja(@RequestBody Granja granja) {
		granjaService.agregarGranja(granja); // la granja no necesita tener ID para el POST
		return new ResponseEntity<Granja>(granja, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Granja> updateGranja(@RequestBody Granja granja, @PathVariable Long id) {
		Granja updatedGranja = granjaService.editarGranja(granja, id); //  la granja SI necesita tener el ID para el PUT
		return new ResponseEntity<>(updatedGranja, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteGranja(@PathVariable Long id) {
		granjaService.eliminarGranja(id); 
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	//FIN GRANJA
	
	//INICIO TIPO
	
	@GetMapping("/{granja_id}/tipos")
	public ResponseEntity<List<TiposAnimales>> getTiposAnimales(@PathVariable Long granja_id) {
		List<TiposAnimales> tipos = tiposService.obtenerTodosLosTiposAnimalesByGranja(granja_id);
		return new ResponseEntity<>(tipos, HttpStatus.OK);
	}

	@GetMapping("/{granja_id}/tipos/{id}")
	public ResponseEntity<TiposAnimales> getTipoDetails(@PathVariable Long id, @PathVariable Long granja_id) {
		TiposAnimales tipo = tiposService.getByGranjaIdAndId(id, granja_id);
		return ResponseEntity.ok(tipo);
	}
	
	@GetMapping("/{granja_id}/tipos/{tipo_id}/animales")
	public ResponseEntity<List<Animal>> getAnimalDetails(@PathVariable Long tipo_id, @PathVariable Long granja_id) {
		TiposAnimales tipo = tiposService.getByGranjaIdAndId(tipo_id, granja_id);
		List<Animal> animales = tipo.getAnimales();
		return new ResponseEntity<>(animales, HttpStatus.OK);
	}
	
	
	@PostMapping("/{granja_id}/tipos")
	public ResponseEntity<TiposAnimales> createTipoAnimal(@PathVariable Long granja_id,  @RequestBody TiposAnimales tipo) {
		Granja granja = granjaService.buscarGranja(granja_id);
		tipo.setGranja(granja);
		TiposAnimales createdTipo = tiposService.agregarTipo(tipo); //no necesita tener ID para el POST
		return new ResponseEntity<>(createdTipo, HttpStatus.CREATED);
	}
	
	@PutMapping("/{granja_id}/tipos/{id}")
	public ResponseEntity<TiposAnimales> updateTipos(@RequestBody TiposAnimales tipo,@PathVariable Long granja_id, @PathVariable Long id) {
		TiposAnimales updatedTipo = tiposService.editarTipo(tipo, granja_id, id); // SI necesita tener el ID para el PUT
	    return new ResponseEntity<>(updatedTipo, HttpStatus.OK);
	}

	@DeleteMapping("/{granja_id}/tipos/{id}")
	public ResponseEntity<Void> deleteTipo(@PathVariable Long granja_id,@PathVariable Long id) {
		tiposService.eliminarTipo(id, granja_id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	//FIN TIPO
	
	
	
}
