package com.accenture.granja.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.granja.model.Compra;

public interface CompraRepository extends JpaRepository<Compra, Long>{
	List<Compra> findByGranjaId(Long granja_id);

}
