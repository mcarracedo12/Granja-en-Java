package com.accenture.granja.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accenture.granja.model.Granja;

public interface GranjaRepository extends JpaRepository<Granja, Long>{
	


}
