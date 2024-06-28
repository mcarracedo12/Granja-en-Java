package com.accenture.granja.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.granja.model.TiposAnimales;
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

/*	public ResponseEntity<TiposAnimales> getByGranjaIdAndId(Long id, Long granja_id) {
		//List<TiposAnimales> tiposAnimales = obtenerTodosLosTiposAnimales();
		TiposAnimales tipos = tiposAnimalesRepository.findByGranjaIdAndId(granja_id, id);
/*		TiposAnimales tipos = null;
		try {
			tipos = tiposAnimales.stream().filter(t->t.getId()== id && t.getGranja().getId()== granja_id).findFirst().get();
			return ResponseEntity.ok(tipos);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("No se encontro ese tipo");
			return ResponseEntity.notFound().build();
		}	
		return ResponseEntity.ok(tipos);
	}
	*/
	
	public  TiposAnimales getByGranjaIdAndId(Long id, Long granja_id) {
		TiposAnimales tipo = tiposRepo.findByGranjaIdAndId(granja_id, id);
		return tipo; 
	}
	
/*	public List<Animal> getByGranjaIdAndTipoId(Long id, Long granja_id) {
		TiposAnimales tipo = tiposAnimalesRepository.findByGranjaIdAndId(granja_id, id);
		return tipo.animales; 
	}    
	*/
	
	public void agregarTipo(TiposAnimales tipo) {
		tiposRepo.save(tipo);
		//System.out.println("tiposAnimalesRepository.save(tipo); desde tiposAnimalesservice.agregarTipo(tipo);");
	}

	public void editarTipo(TiposAnimales tipo) {
		tiposRepo.save(tipo);		
	}

	public void eliminarTipo(Long id) {
		tiposRepo.deleteById(id);
	}

}
