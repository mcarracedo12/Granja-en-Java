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
import com.accenture.granja.model.Venta;
import com.accenture.granja.services.VentaService;

@RestController
@CrossOrigin(origins = "http://localhost:4200") 
public class VentaController {
	@Autowired
	private VentaService ventaService;
	
	  @GetMapping("/ventas")
	   public List<Venta> getVentas() {
	            // Aca se instancia al Servicio donde esta la logica central
	       return ventaService.obtenerTodasLasVentas();
	   }
	
	  @GetMapping("granjas/{granja_id}/ventas")
	   public List<Venta> getVentas(@PathVariable Long granja_id) {
	       return ventaService.obtenerTodasMisVentas(granja_id);
	   }
	  
	  @GetMapping("/granjas/{granja_id}/ventas/{id}")
		public ResponseEntity<Venta> getVentaDetails(@PathVariable Long id, @PathVariable Long granja_id ) {
			Venta venta = ventaService.getVentaByIdAndGranjaId(id, granja_id);
	        if (venta != null) {
	            return ResponseEntity.ok(venta);
	        } else {
	            return ResponseEntity.notFound().build();
	        }	 
	  
		}
	  
		
	

		
		@PostMapping("/ventas")
		public void createVenta(@RequestBody Venta venta) {
			ventaService.agregarVenta(venta);
		}
		
		
		@PutMapping("/ventas/{id}")
		public void updateVenta(@RequestBody Venta venta, @PathVariable Long id) {
			ventaService.editarVenta(venta);
		}
		
		@DeleteMapping("/ventas/{id}")
		public void deleteVenta(@PathVariable Long id) {
			ventaService.eliminarVenta(id);
		}
		

}
