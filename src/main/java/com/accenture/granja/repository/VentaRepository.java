package com.accenture.granja.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accenture.granja.model.Venta;
@Repository
public interface VentaRepository extends JpaRepository<Venta, Long>{
	List<Venta> findByGranjaId(Long granja_id);
	Venta findByGranjaIdAndId(Long granjaId, Long id);

}
