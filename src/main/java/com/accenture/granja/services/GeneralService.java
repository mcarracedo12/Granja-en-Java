package com.accenture.granja.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.granja.model.Compra;
import com.accenture.granja.model.TiposAnimales;
import com.accenture.granja.repository.AnimalRepository;
import com.accenture.granja.repository.CompraRepository;
import com.accenture.granja.repository.GranjaRepository;
import com.accenture.granja.repository.TipoAnimalRepository;
import com.accenture.granja.repository.VentaRepository;

@Service
@Transactional// Hace un rollback si algo va mal en la transaccion
public class GeneralService {

	@Autowired
	private GranjaRepository granjaRepo;
	private TipoAnimalRepository tiposRepo;
	private AnimalRepository animalRepo;
	private CompraRepository compraRepo;
	private VentaRepository ventaRepo;

	
	
	public void actualizarPreciosVenta(double porcentaje) {
		List<TiposAnimales> listaTipos = tiposRepo.findByGranjaId((long)1);
		System.out.println("Nuevos precios: ");
		for(TiposAnimales tipo : listaTipos) {
			double precioActual = tipo.getPrecioVenta();
			tipo.setPrecioVenta(precioActual * porcentaje);	
			tiposRepo.save(tipo);
		}
		
		listaTipos = tiposRepo.findByGranjaId((long)1);
		for(TiposAnimales tipo : listaTipos) {
			System.out.println(tipo.getAnimal()+" : " + tipo.getPrecioVenta());	
		}
	}
	
/*	private void reproducirGanado() {
	System.out.println("Voy a reproducir Ganado");
	//for(LocalDate i = ultimaActualizacion; i.isBefore(now); i.plusDays(1)) {
	LocalDate i = ultimaActualizacion;
	while( i.isBefore(now)) {
		System.out.println("Fecha de reproduccion: " + i);
		for (Pollito pollito : pollitos) {
			pollito.reproducir(i);
		}
		for (Huevo huevo: huevos) {
			huevo.reproducir(i);
		}
		eliminarExpirados(i);
		 i.plusDays(1);
	}
	
	System.out.println("La ultima fecha de Actualizacion es: " + granjaRepo.findById((long) 1)).get;
}*/
}
