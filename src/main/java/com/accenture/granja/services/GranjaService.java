package com.accenture.granja.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.granja.model.Granja;
import com.accenture.granja.repository.GranjaRepository;


@Service
public class GranjaService {

	@Autowired
	private GranjaRepository granjaRepo;


	public Granja buscarGranja(Long id) {
		Granja granja= granjaRepo.findById(id).orElse(null);
		return granja;

	}

	public List<Granja> buscarGranjas() {
		List<Granja> granjas= granjaRepo.findAll();
		return granjas;
	}

	public Granja editarGranja(Granja granja) {
		return granjaRepo.save(granja);
	}


	public void agregarGranja(Granja granja) {
		granjaRepo.save(granja);
	}

	public void eliminarGranja(Long id) {
		granjaRepo.deleteById(id);	
	}

}
