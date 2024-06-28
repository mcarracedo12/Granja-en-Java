package com.accenture.granja.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.granja.model.Venta;
import com.accenture.granja.repository.VentaRepository;
@Service
@Transactional
public class VentaService {
	
	@Autowired
	private VentaRepository ventaRepo;
	// VENTAS
	
		public List<Venta> obtenerTodasLasVentas() {
			// Aca se instancia al repositorio, es la capa final ya que se consulta a la base de datos
			return ventaRepo.findAll();
		}    
		
		public List<Venta> obtenerTodasMisVentas(Long granja_id) {
			return ventaRepo.findByGranjaId(granja_id);
		}  
		
		public Venta getVentaByIdAndGranjaId(Long id, Long granjaId) {
	        return ventaRepo.findByGranjaIdAndId(granjaId, id);
	    }
		
		
		
		public List<Venta> buscarVentasByGranjaId(Long granjaId){
			return ventaRepo.findByGranjaId(granjaId);
			
		}

		public Venta buscarVentaById(Long id) {
			Venta venta= ventaRepo.findById(id).orElse(null);
			return venta;
		}
		
		
		public void agregarVenta(Venta venta) {
			ventaRepo.save(venta);
			
		}

		public void editarVenta(Venta venta) {
			ventaRepo.save(venta);
			
		}

		public void eliminarVenta(Long id) {
			ventaRepo.deleteById(id);		
		}    
		
		
		// FIN VENTAS

}
