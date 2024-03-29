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
import com.accenture.granja.model.Venta;
import com.accenture.granja.services.GeneralService;

@RestController
@CrossOrigin(origins = "http://localhost:4200") 
public class VentaController {
	@Autowired
	private GeneralService service;
	
	  @GetMapping("/ventas")
	   public List<Venta> getVentas() {
	            // Aca se instancia al Servicio donde esta la logica central
	       return service.obtenerTodasLasVentas();
	   }
	
	  @GetMapping("granjas/{granja_id}/ventas")
	   public List<Venta> getVentas(@PathVariable Long granja_id) {
	       return service.obtenerTodasMisVentas(granja_id);
	   }
	  
		@GetMapping("/granjas/{granja_id}/ventas/{id}")
		public ResponseEntity<Venta> getVentaDetails(@PathVariable Long id, @PathVariable Long granja_id ) {
			Venta venta = service.getVentaByIdAndGranjaId(id, granja_id);
	        if (venta != null) {
	            return ResponseEntity.ok(venta);
	        } else {
	            return ResponseEntity.notFound().build();
	        }	 
		}
	  
	  @GetMapping("/granjas/{granja_id}/ventas/{id}/productos")
		public List<Animal> getAnimalDetails(@PathVariable Long id, @PathVariable Long granja_id ) {
			List<Animal>  productos ;
			Venta venta = service.getVentaByIdAndGranjaId(id, granja_id);
			productos = venta.productos;
			return productos;	        
	}
		
	

		
		@PostMapping("/ventas")
		public void createVenta(@RequestBody Venta venta) {
			service.agregarVenta(venta);
		}
		
		
		@PutMapping("/ventas/{id}")
		public void updateVenta(@RequestBody Venta venta, @PathVariable Long id) {
			service.editarVenta(venta);
		}
		
		@DeleteMapping("/ventas/{id}")
		public void deleteVenta(@PathVariable Long id) {
			service.eliminarVenta(id);
		}
		

}
