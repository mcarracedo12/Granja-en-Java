package com.accenture.granja.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.granja.beans.Huevo;
import com.accenture.granja.repository.HuevoRepository;

@RestController
public class HuevoController {

	@Autowired
	private HuevoRepository repository;
	
	@GetMapping("/huevos")
	public List<Huevo> getHuevos() {
		return repository.findAll();
	}
	
}
