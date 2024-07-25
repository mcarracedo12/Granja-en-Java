package com.accenture.granja.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.accenture.granja.model.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long>{

	//List<Animal> findByGranjaIdAndTipoId(Long granja_id, Long tipo_id);
	// Consulta personalizada para obtener todos los huevos vendidos en el día actual
	//@Query("SELECT h FROM Huevo h WHERE DATE(h.fechaVenta) = CURRENT_DATE")
	//   List<Huevo> findAllHuevosVendidosHoy();
	
	// Consulta para obtener todos los huevos por fecha de expiracion
	//@Query("SELECT * FROM ANIMAL WHERE TIPO_ANIMAL_ID = 1 ORDER BY FECHA_EXPIRACION")
	
	//List<Animal> findByGranjaIdAndTipo(Long granja_id, Long tipo_id);
	/*Animal findByGranjaIdAndId(Long granjaId, Long id);
	List <Animal> findByGranjaId(Long granja_id);
	*/
	
	List<Animal> findByTiposAnimalesId(Long tiposAnimalesId);
	
	
	@Query(value = "SELECT * FROM ANIMAL WHERE TIPOS_ANIMAL_ID = tiposAnimalesId AND GRANJA_ID = granjaId ORDER BY FECHA_EXPIRACION ASC", nativeQuery = true)
	List<Animal> findByTiposAnimalesOrderedByDate(@Param("granjaId")Long granjaId, @Param("tiposAnimalesId")Long tiposAnimalesId);
	
	Optional<Animal> findById(Long id);
	void deleteById(Long id);
	

}
