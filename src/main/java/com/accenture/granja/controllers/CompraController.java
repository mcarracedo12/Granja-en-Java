package com.accenture.granja.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.granja.beans.Compra;
import com.accenture.granja.repository.CompraRepository;

@RestController
public class CompraController {
	@Autowired
	private CompraRepository repository;
	
	@GetMapping("/compras")
	public List<Compra> getCompras(){
		return repository.findAll();
	}

}
