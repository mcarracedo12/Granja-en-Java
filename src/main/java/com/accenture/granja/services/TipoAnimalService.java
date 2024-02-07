package com.accenture.granja.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.accenture.granja.model.TiposAnimales;
import com.accenture.granja.repository.TipoAnimalRepository;


@Service
public class TipoAnimalService {


	// Aca se instancia al repositorio, es la capa final ya que se consulta a la base de datos

	@Autowired
	private TipoAnimalRepository tiposAnimalesRepository;

	public List<TiposAnimales> obtenerTodosLosTiposAnimales() {  
		return tiposAnimalesRepository.findAll();
	}    

	public TiposAnimales getById(long tipoAnimalId) {
		return tiposAnimalesRepository.findById(tipoAnimalId)
				.orElseThrow(() -> new RuntimeException("Tipo de animal no encontrado con ID: " + tipoAnimalId));
	}

	public ResponseEntity<TiposAnimales> getByGranjaIdAndId(long granja_id, long id) {
		List<TiposAnimales> tiposAnimales = obtenerTodosLosTiposAnimales();

		TiposAnimales tipos = null;
		try {
			tipos = tiposAnimales.stream().filter(t->t.getId()== id && t.getGranjaId()== granja_id).findFirst().get();
			return ResponseEntity.ok(tipos);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("No se encontro ese tipo");
			return ResponseEntity.notFound().build();
		}
	}
	
	public void agregarTipo(TiposAnimales tipo) {
		tiposAnimalesRepository.save(tipo);
	}

	public void editarTipo(TiposAnimales tipo) {
		tiposAnimalesRepository.save(tipo);		
	}

	public void eliminarTipo(Long id) {
		tiposAnimalesRepository.deleteById(id);
	}

	public List<TiposAnimales> obtenerTodosLosTiposAnimalesByGranja(long granja_id) {
		List<TiposAnimales> allTipos = obtenerTodosLosTiposAnimales();
		 /*List<TiposAnimales> tipos = new ArrayList<>();
		    // Filtrar los tipos de animales para la granja específica
		    for (TiposAnimales tipo : allTipos) {
		        if (tipo.getGranjaId()==granja_id) {
		            tipos.add(tipo);
		        }
		    }
		    */
		 // Filtrar los tipos de animales para la granja específica usando Stream API
		    List<TiposAnimales> tipos = allTipos.stream()
		            .filter(tipo -> tipo.getGranjaId()==granja_id)
		            .collect(Collectors.toList());
		    
		return tipos;
	}


}
