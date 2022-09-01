package com.accenture.granja.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.granja.beans.Pollito;
import com.accenture.granja.repository.PollitoRepository;

@RestController
public class PollitoController {
	@Autowired
	private PollitoRepository repository;
	
	@GetMapping("/pollitos")
	public List<Pollito> getPollitos(){
		return repository.findAll();
	}

}
