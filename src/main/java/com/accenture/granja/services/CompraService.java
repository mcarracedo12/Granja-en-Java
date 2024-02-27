package com.accenture.granja.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.granja.model.Compra;
import com.accenture.granja.repository.CompraRepository;
@Service
@Transactional// Hace un rollback si alg ova mal en la transaccion
public class CompraService {

	@Autowired
	private CompraRepository compraRepository;

	public List<Compra> obtenerTodasLasCompras() {
		// Aca se instancia al repositorio, es la capa final ya que se consulta a la base de datos
		return compraRepository.findAll();
	}

	public Compra buscarCompraById(Long id) {
		Compra compra= compraRepository.findById(id).orElse(null);
		return compra;
	}
	
	public Compra getCompraByIdAndGranjaId(Long id, Long granjaId) {
        return compraRepository.findByGranjaIdAndId(granjaId, id);
    }
	
	
	public List<Compra> buscarComprasByGranjaId(Long granjaId){
		return compraRepository.findByGranjaId(granjaId);
		
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
