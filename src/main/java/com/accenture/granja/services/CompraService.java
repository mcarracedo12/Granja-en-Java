package com.accenture.granja.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.granja.model.Compra;
import com.accenture.granja.repository.CompraRepository;
@Service
@Transactional// Hace un rollback si algo va mal en la transaccion
public class CompraService {

	@Autowired
	private CompraRepository compraRepo;

	public List<Compra> obtenerTodasLasCompras() {
		// Aca se instancia al repositorio, es la capa final ya que se consulta a la base de datos
		return compraRepo.findAll();
	}

	public Compra buscarCompraById(Long id) {
		Compra compra= compraRepo.findById(id).orElse(null);
		return compra;
	}
	
	public Compra getCompraByIdAndGranjaId(Long id, Long granjaId) {
        return compraRepo.findByGranjaIdAndId(granjaId, id);
    }
	
	
	public List<Compra> buscarComprasByGranjaId(Long granjaId){
		return compraRepo.findByGranjaId(granjaId);
		
	}
	
	public Compra getByGranjaIdAndId(Long id, Long granja_id) {
		Compra compra = compraRepo.findByGranjaIdAndId(granja_id, id);
		return compra; 
	} 

	public void agregarCompra(Compra compra) {
		compraRepo.save(compra);
		
	}

	public void editarCompra(Compra compra) {
		compraRepo.save(compra);
		
	}

	public void eliminarCompra(Long id) {
		compraRepo.deleteById(id);		
	}

   


}
