package com.accenture.granja.services;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.accenture.granja.exceptions.NoContentException;
import com.accenture.granja.model.Granja;
import com.accenture.granja.repository.GranjaRepository;
@Service
@Transactional
public class GranjaService {
	@Autowired
	private GranjaRepository granjaRepo;

	public List<Granja> buscarGranjas() {
		List<Granja> granjas = granjaRepo.findAll();
        if (granjas.isEmpty()) {
            throw new NoContentException("No hay granjas por el momento");
        }
        return granjas;
	}
	
	public Granja buscarGranja(Long id) {
		 return granjaRepo.findById(id)
	                .orElseThrow(() -> new NoContentException("No hay granja con ID: " + id));
	    }
	
	public void agregarGranja(Granja granja) {
		try {
			granjaRepo.save(granja);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Granja editarGranja(Granja granja, Long id) {
		   if (!granjaRepo.existsById(id)) {
	            throw new NoContentException("No hay granja con ID: " + id);
	        }
	        granja.setId(id);
	        return granjaRepo.save(granja);
	    }

	public void eliminarGranja(Long id) {
		 if (!granjaRepo.existsById(id)) {
	            throw new NoContentException("No hay granja con ID: " + id);
	        }
	        granjaRepo.deleteById(id);
	    }	
	
	
}
