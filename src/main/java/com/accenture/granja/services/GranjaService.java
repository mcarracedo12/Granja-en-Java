package com.accenture.granja.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.granja.model.Granja;
import com.accenture.granja.repository.GranjaRepository;


@Service
public class GranjaService implements IGranjaService {
    
    @Autowired
    public GranjaRepository granjaRepo;

    @Override
    public Granja buscarGranja(Integer id) {
    	Granja granja= granjaRepo.findById(id).orElse(null);
         return granja;
         
    }

    @Override
    public Granja editarGranja(Granja granja) {
        return granjaRepo.save(granja);
    }

}
