package com.accenture.granja.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.granja.model.Compra;
import com.accenture.granja.repository.CompraRepository;
@Service
public class CompraService {

	@Autowired
	private CompraRepository compraRepository;

	public List<Compra> obtenerTodasLasCompras() {
		// Aca se instancia al repositorio, es la capa final ya que se consulta a la base de datos
		return compraRepository.findAll();
	}

	public Compra buscarCompra(Long id) {
		Compra compra= compraRepository.findById(id).orElse(null);
		return compra;
	}

	public void agregarCompra(Compra compra) {
		compraRepository.save(compra);
		
	}

	public void editarCompra(Compra compra) {
		compraRepository.save(compra);
		
	}

	public void eliminarCompra(Long id) {
		compraRepository.deleteById(id);		
	}    


}
