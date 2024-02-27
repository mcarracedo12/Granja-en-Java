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

import com.accenture.granja.model.Compra;
import com.accenture.granja.services.CompraService;

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

	@GetMapping("/granjas/{granja_id}/compras")
	public List<Compra> getComprasMisCompras(@PathVariable Long granja_id) {
		return compraService.buscarComprasByGranjaId(granja_id);
	}
	
	@GetMapping("/granjas/{granja_id}/compras/{id}")
	public ResponseEntity<Compra> getCompraDetails(@PathVariable Long id, @PathVariable Long granja_id ) {
		Compra compra = compraService.getCompraByIdAndGranjaId(id, granja_id);
        if (compra != null) {
            return ResponseEntity.ok(compra);
        } else {
            return ResponseEntity.notFound().build();
        }	 
	}
	
	@PostMapping("/compras")
	public void createCompra(@RequestBody Compra compra) {
		compraService.agregarCompra(compra);
	}
	
	
	@PutMapping("/compras/{id}")
	public void updateCompra(@RequestBody Compra compra, @PathVariable Long id) {
		compraService.editarCompra(compra);
	}
	
	@DeleteMapping("/compras/{id}")
	public void deleteCompra(@PathVariable Long id) {
		compraService.eliminarCompra(id);
	}
	

}
