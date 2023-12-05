package com.accenture.granja.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.granja.model.Huevo;

public interface HuevoRepository extends JpaRepository<Huevo, Long>{
	// Consulta personalizada para obtener todos los huevos vendidos en el día actual
	//@Query("SELECT h FROM Huevo h WHERE DATE(h.fechaVenta) = CURRENT_DATE")
	//   List<Huevo> findAllHuevosVendidosHoy();


}
