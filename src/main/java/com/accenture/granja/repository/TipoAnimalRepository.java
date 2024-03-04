package com.accenture.granja.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.granja.model.TiposAnimales;


public interface TipoAnimalRepository extends JpaRepository<TiposAnimales, Long>{
	// Consulta personalizada para obtener todos los huevos vendidos en el día actual
	//@Query("SELECT h FROM Huevo h WHERE DATE(h.fechaVenta) = CURRENT_DATE")
	//   List<Huevo> findAllHuevosVendidosHoy();
	List<TiposAnimales> findByGranjaId(Long granja_id);
	TiposAnimales findByGranjaIdAndId(Long granja_id, Long id);
	//List<Animal> findAnimalesByGranjaIdAndTipoId(Long granja_id, Long id);
	
}