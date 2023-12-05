package com.accenture.granja.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.accenture.granja.model.Venta;
import com.accenture.granja.repository.VentaRepository;

public class VentaService {

	private final VentaRepository ventaRepository;

	   @Autowired
	   public VentaService(VentaRepository ventaRepository) {

	       this.ventaRepository = ventaRepository;

	   }
	   
	   public List<Venta> obtenerTodasLasVentas() {

	        // Aca se instancia al repositorio, es la capa final ya que se consulta a la base de datos
	    return ventaRepository.findAll();

	   }    

}
