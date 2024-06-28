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
import com.accenture.granja.model.Compra;
import com.accenture.granja.services.CompraService;
import com.accenture.granja.services.GeneralService;

@RestController
@CrossOrigin(origins = "http://localhost:4200") 
public class CompraController {
	@Autowired
	private CompraService compraService;
	
	// Aca se instancia al Servicio donde esta la logica central
	
	@GetMapping("/compras")
	public List<Compra> getCompras() {
		return compraService.obtenerTodasLasCompras();
	}
	/*
	@GetMapping("/granjas/{granja_id}/compras")
	public List<Compra> getComprasMisCompras(@PathVariable Long granja_id) {
		return service.buscarComprasByGranjaId(granja_id);
	}
	
	@GetMapping("/granjas/{granja_id}/compras/{id}")
	public ResponseEntity<Compra> getCompraDetails(@PathVariable Long id, @PathVariable Long granja_id ) {
		Compra compra = service.getCompraByIdAndGranjaId(id, granja_id);
        if (compra != null) {
            return ResponseEntity.ok(compra);
        } else {
            return ResponseEntity.notFound().build();
        }	 
	}
	*/
	@GetMapping("/compras/{id}")
	public ResponseEntity<Compra> getCompraDetails(@PathVariable Long id) {
		Compra compra = compraService.getCompraById(id);
        if (compra != null) {
            return ResponseEntity.ok(compra);
        } else {
            return ResponseEntity.notFound().build();
        }	 
	}
/*	
	 @GetMapping("/granjas/{granja_id}/compras/{id}/productos")
		public List<Animal> getAnimalDetails(@PathVariable Long id, @PathVariable Long granja_id ) {
			List<Animal>  productos ;
			Compra compra = service.getComprasByGranjaIdAndId(id, granja_id);
			productos= ResponseEntity.ok(compra).getBody().productos;
	            return productos;
	}
	*/
	
	@GetMapping("/compras/{id}/productos")
	public List<Animal> getAnimalDetails(@PathVariable Long id) {
		Compra compra = compraService.getCompraById(id);
		List<Animal>  productos = compra.productos;
        return productos; 
	}
	
	
	@PostMapping("/compras")
	public void createCompra(@RequestBody Compra compra) {
		compraService.agregarCompra(compra);
	}
	
/*	@PostMapping("/compras/{id}/productos")
	public void agregarProducto(@RequestBody List<Animal> productos, @PathVariable Long id) {
		Compra compra = service.getCompraById(id);
		for(Animal p : productos) {
			service.asignarCompra(p, id);
			
			//Long tipo_id = p.getTipoId();
			service.agregarAnimal(p);
		}
	}
	*/
	
	@PutMapping("/compras/{id}")
	public void updateCompra(@RequestBody Compra compra, @PathVariable Long id) {
		compraService.editarCompra(compra);
	}
	
	@DeleteMapping("/compras/{id}")
	public void deleteCompra(@PathVariable Long id) {
		compraService.eliminarCompra(id);
	}
	

}
