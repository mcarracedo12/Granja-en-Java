package com.accenture.granja.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.granja.model.Venta;
import com.accenture.granja.services.VentaService;

@RestController
public class VentaController {
	private VentaService ventaService;
	@Autowired
	public VentaController(VentaService ventaService) {

	       this.ventaService = ventaService;

	   }

	  @GetMapping("/ventas")
	   public List<Venta> getVentas() {

	            // Aca se instancia al Servicio donde esta la logica central
	       return ventaService.obtenerTodasLasVentas();

	   }

}
