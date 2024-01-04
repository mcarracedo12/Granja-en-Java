package com.accenture.granja.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.granja.model.Animal;


public interface AnimalRepository extends JpaRepository<Animal, Integer>{
	// Consulta personalizada para obtener todos los huevos vendidos en el día actual
	//@Query("SELECT h FROM Huevo h WHERE DATE(h.fechaVenta) = CURRENT_DATE")
	//   List<Huevo> findAllHuevosVendidosHoy();
	
	// Consulta para obtener todos los huevos por fecha de expiracion
	//@Query("SELECT * FROM ANIMAL WHERE TIPO_ANIMAL_ID = 1 ORDER BY FECHA_EXPIRACION")
	
	
	

}
