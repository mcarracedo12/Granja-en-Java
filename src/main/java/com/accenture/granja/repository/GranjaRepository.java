package com.accenture.granja.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.granja.model.Granja;
public interface GranjaRepository extends JpaRepository<Granja, Integer>{


}
