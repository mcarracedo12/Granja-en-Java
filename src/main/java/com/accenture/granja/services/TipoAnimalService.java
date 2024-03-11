package com.accenture.granja.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.granja.model.Granja;
import com.accenture.granja.model.TiposAnimales;
import com.accenture.granja.repository.GranjaRepository;
import com.accenture.granja.repository.TipoAnimalRepository;


@Service
public class TipoAnimalService {


	// Aca se instancia al repositorio, es la capa final ya que se consulta a la base de datos

	@Autowired
	private TipoAnimalRepository tiposRepo;
	private GranjaRepository granjaRepo;

	public List<TiposAnimales> obtenerTodosLosTiposAnimales() {  
		return tiposRepo.findAll();
	}    
	
	public List<TiposAnimales> obtenerTodosLosTiposAnimalesByGranja(Long granja_id) {
		//List<TiposAnimales> allTipos = obtenerTodosLosTiposAnimales();
		/* List<TiposAnimales> tipos = new ArrayList<>();
		    // Filtrar los tipos de animales para la granja específica
		    for (TiposAnimales tipo : allTipos) {
		        if (tipo.getGranjaId()==granja_id) {
		            tipos.add(tipo);
		        }
		    }
		  */  
		
		 // Filtrar los tipos de animales para la granja específica usando Stream API
		/*List<TiposAnimales> tipos = allTipos.stream()
		            .filter(tipo -> tipo.getGranjaId()==granja_id)
		            .collect(Collectors.toList());
		  */
		List<TiposAnimales> tipos = tiposRepo.findByGranjaId(granja_id);
		return tipos;
	}

	public TiposAnimales getById(long tipoAnimalId) {
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
