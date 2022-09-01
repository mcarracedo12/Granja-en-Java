package com.accenture.granja.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.granja.beans.Venta;
import com.accenture.granja.repository.VentaRepository;

@RestController
public class VentaController {
	@Autowired
	private VentaRepository repository;
	
	@GetMapping("/ventas")
	public List<Venta> getVentas(){
		return repository.findAll();
	}

}
