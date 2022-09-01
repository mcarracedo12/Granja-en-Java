package com.accenture.granja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.granja.beans.Huevo;

public interface HuevoRepository extends JpaRepository<Huevo, Long>{

}
