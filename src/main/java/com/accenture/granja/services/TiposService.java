package com.accenture.granja.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.granja.exceptions.NoContentException;
import com.accenture.granja.model.TiposAnimales;
import com.accenture.granja.repository.TipoAnimalRepository;
@Service
@Transactional
public class TiposService {

	@Autowired TipoAnimalRepository tiposRepo;    
	
	public List<TiposAnimales> obtenerTodosLosTiposAnimalesByGranja(Long granja_id) {
		return tiposRepo.findByGranjaId(granja_id).orElseThrow(() -> new RuntimeException("Tipo de animal no encontrado en la granja: " + granja_id));
		//return tipos;
	}

	public TiposAnimales getTipoById(long tipoAnimalId) {
		return tiposRepo.findById(tipoAnimalId)
				.orElseThrow(() -> new RuntimeException("Tipo de animal no encontrado con ID: " + tipoAnimalId));
	}
	
	public TiposAnimales getByGranjaIdAndId(Long id, Long granja_id) {
		TiposAnimales tipo = tiposRepo.findByGranjaIdAndId(granja_id, id);
		if(tipo==null) {
			throw new NoContentException("No existe el tipo " + id + " en la granja " + granja_id);
		}
		return tipo; 
	}

	public TiposAnimales agregarTipo(TiposAnimales tipo) {
		return tiposRepo.save(tipo);
	}

	public TiposAnimales editarTipo(TiposAnimales tipo, Long granjaId, Long id) {
        if (tiposRepo.findByGranjaIdAndId(granjaId, id)!= null) {
        	return tiposRepo.save(tipo);           
        }
        throw new NoContentException("No hay tipo de animal con ID: " + id + " en la granja con ID: " + granjaId);
    }

	public void eliminarTipo(Long id, Long granjaId) {
	    if (tiposRepo.findByGranjaIdAndId(granjaId, id) == null) {
	        throw new NoContentException("No hay tipo de animal con ID: " + id + " en granja " + granjaId);
	    }
	    tiposRepo.deleteById(id);
	}


}
