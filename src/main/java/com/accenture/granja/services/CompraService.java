package com.accenture.granja.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.granja.model.Compra;
import com.accenture.granja.repository.CompraRepository;
@Service
public class CompraService {
	private final CompraRepository compraRepository;

	   @Autowired
	   public CompraService(CompraRepository compraRepository) {

	       this.compraRepository = compraRepository;

	   }
	   
	   public List<Compra> obtenerTodasLasCompras() {

	        // Aca se instancia al repositorio, es la capa final ya que se consulta a la base de datos
	    return compraRepository.findAll();

	   }    

	   
}
