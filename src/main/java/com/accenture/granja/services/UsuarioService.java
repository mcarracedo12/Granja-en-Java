package com.accenture.granja.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.granja.model.Usuario;
import com.accenture.granja.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired UsuarioRepository usuarioRepository;

	public List<Usuario> buscarUsuariosByGranja(Long granja_id) {
		List<Usuario> usuarios = usuarioRepository.findUsuariosByGranjaId(granja_id);
		return usuarios;
	} 

}
