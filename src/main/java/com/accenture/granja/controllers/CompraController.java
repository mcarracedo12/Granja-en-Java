package com.accenture.granja.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.granja.model.Compra;
import com.accenture.granja.services.CompraService;

@RestController
public class CompraController {
private CompraService compraService;
	
	@Autowired
	public CompraController(CompraService compraService) {

	       this.compraService = compraService;

	   }

	  @GetMapping("/compras")
	   public List<Compra> getCompras() {

	            // Aca se instancia al Servicio donde esta la logica central
	       return compraService.obtenerTodasLasCompras();

	   }


}
