package com.accenture.granja.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.granja.model.Compra;
import com.accenture.granja.model.Venta;
import com.accenture.granja.repository.VentaRepository;

@Service
public class VentaService {

	@Autowired
	private VentaRepository ventaRepository;

	public List<Venta> obtenerTodasLasVentas() {
		// Aca se instancia al repositorio, es la capa final ya que se consulta a la base de datos
		return ventaRepository.findAll();
	}    
	
	public Venta buscarVenta(Long id) {
		Venta venta= ventaRepository.findById(id).orElse(null);
		return venta;
	}

	public void agregarVenta(Venta venta) {
		ventaRepository.save(venta);
		
	}

	public void editarVenta(Venta venta) {
		ventaRepository.save(venta);
		
	}

	public void eliminarVenta(Long id) {
		ventaRepository.deleteById(id);		
	}    


}
