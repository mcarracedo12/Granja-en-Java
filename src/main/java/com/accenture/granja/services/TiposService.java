package com.accenture.granja.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.granja.exceptions.NoContentException;
import com.accenture.granja.model.TiposAnimales;
import com.accenture.granja.repository.GranjaRepository;
import com.accenture.granja.repository.TipoAnimalRepository;
@Service
@Transactional
public class TiposService {

	@Autowired TipoAnimalRepository tiposRepo;    
	
	public List<TiposAnimales> obtenerTodosLosTiposAnimalesByGranja(Long granja_id) {
	
		List<TiposAnimales> tipos = tiposRepo.findByGranjaId(granja_id);
		return tipos;
	}

	public TiposAnimales getTipoById(long tipoAnimalId) {
		return tiposRepo.findById(tipoAnimalId)
				.orElseThrow(() -> new RuntimeException("Tipo de animal no encontrado con ID: " + tipoAnimalId));
	}
	
	public  TiposAnimales getByGranjaIdAndId(Long id, Long granja_id) {
		TiposAnimales tipo = tiposRepo.findByGranjaIdAndId(granja_id, id);
		return tipo; 
	}

	public TiposAnimales agregarTipo(TiposAnimales tipo) {
		tiposRepo.save(tipo);
		return tipo;
	}

	public TiposAnimales editarTipo(TiposAnimales tipo, Long granjaId, Long id) {
        if (tiposRepo.findByGranjaIdAndId(granjaId, id)!= null) {
        	return tiposRepo.save(tipo);           
        }
        throw new NoContentException("No hay tipo de animal con ID: " + id + " en la granja con ID: " + granjaId);
    }

	public void eliminarTipo(Long id, Long granjaId) {
        if (tiposRepo.findByGranjaIdAndId(granjaId, id)!= null) {
        	tiposRepo.deleteById(id);
        }
        throw new NoContentException("No hay tipo de animal con ID: " + id + " en granja " + granjaId);
	}

}
