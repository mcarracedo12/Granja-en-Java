package com.accenture.granja.services;

import com.accenture.granja.model.Granja;

public interface IGranjaService {

	 public Granja buscarGranja (Integer id);
	    
	 public Granja editarGranja (Granja granja);
}
