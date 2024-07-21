package com.accenture.granja.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accenture.granja.model.Usuario;
import com.google.common.base.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	List<Usuario> findUsuariosByGranjaId(Long granja_id);

}
