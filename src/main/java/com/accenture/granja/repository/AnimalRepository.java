package com.accenture.granja.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.granja.model.Animal;
import com.accenture.granja.model.Compra;


public interface AnimalRepository extends JpaRepository<Animal, Long>{
	// Consulta personalizada para obtener todos los huevos vendidos en el día actual
	//@Query("SELECT h FROM Huevo h WHERE DATE(h.fechaVenta) = CURRENT_DATE")
	//   List<Huevo> findAllHuevosVendidosHoy();
	
	// Consulta para obtener todos los huevos por fecha de expiracion
	//@Query("SELECT * FROM ANIMAL WHERE TIPO_ANIMAL_ID = 1 ORDER BY FECHA_EXPIRACION")
	
	//List<Animal> findByGranjaIdAndTipo(Long granja_id, Long tipo_id);
	/*Animal findByGranjaIdAndId(Long granjaId, Long id);
	List <Animal> findByGranjaId(Long granja_id);
	*/
	

}
