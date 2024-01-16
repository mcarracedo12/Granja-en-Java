package com.accenture.granja.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.granja.model.Venta;
import com.accenture.granja.services.VentaService;

@RestController
public class VentaController {
	@Autowired
	private VentaService ventaService;
	
	  @GetMapping("/ventas")
	   public List<Venta> getVentas() {
	            // Aca se instancia al Servicio donde esta la logica central
	       return ventaService.obtenerTodasLasVentas();
	   }
	  
		
		@GetMapping("/ventas/{id}")
		public Venta getVentaDetails(@PathVariable Long id) {
			return ventaService.buscarVenta(id);
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
