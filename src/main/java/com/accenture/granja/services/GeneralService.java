package com.accenture.granja.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.granja.model.Animal;
import com.accenture.granja.model.Compra;
import com.accenture.granja.model.Granja;
import com.accenture.granja.model.TiposAnimales;
import com.accenture.granja.model.Venta;
import com.accenture.granja.repository.AnimalRepository;
import com.accenture.granja.repository.CompraRepository;
import com.accenture.granja.repository.GranjaRepository;
import com.accenture.granja.repository.TipoAnimalRepository;
import com.accenture.granja.repository.VentaRepository;

@Service
@Transactional// Hace un rollback si algo va mal en la transaccion
public class GeneralService {

	@Autowired
	private GranjaRepository granjaRepo;
	@Autowired
	private TipoAnimalRepository tiposRepo;
	@Autowired
	private AnimalRepository animalRepo;
	@Autowired
	private CompraRepository compraRepo;
	@Autowired
	private VentaRepository ventaRepo;


// GRANJA

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
	
	
// FIN GRANJA
	
	// TIPOS
	

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

	// FIN TIPOS
	
	
	// ANIMALES
	
	public List<Animal> obtenerTodosLosAnimales() {
		// Aca se instancia al repositorio, es la capa final ya que se consulta a la base de datos
		return animalRepo.findAll();
	}
	
	public List<Animal> getAnimalByTipoId(Long tipos_animal_id) {
		return animalRepo.findByTiposAnimales_id(tipos_animal_id);
	}

	public Animal getAnimalById(Long id) {
		Animal animal= animalRepo.findById(id).orElse(null);
		return animal;
	}

	public void agregarAnimal(Animal animal) {
		animalRepo.save(animal);
	}
	
	public void agregarAnimal(Animal animal, Long tipoId) {
		  Optional<TiposAnimales> ta = tiposRepo.findById(tipoId);
		  animal.setTiposAnimales(ta.get());
		  agregarAnimal(animal);
	}
	
	public void asignarCompra(Animal animal, Long compraId) {
		  Optional<Compra> compra = compraRepo.findById(compraId);
		  animal.setCompra(compra.get());
		  animal.setPrecioCompra();
		  //editarAnimal(animal);
	}
	
	public void editarAnimal(Animal animal) {
		animalRepo.save(animal);
	}

	public void eliminarAnimal(Long id) {
		animalRepo.deleteById(id);
	}

// FIN ANIMALES
	
	// COMPRAS
	
	public List<Compra> obtenerTodasLasCompras() {
		return compraRepo.findAll();
	}

	public Compra buscarCompraById(Long id) {
		Compra compra= compraRepo.findById(id).orElse(null);
		return compra;
	}
/*	
	public Compra getCompraByIdAndGranjaId(Long id, Long granjaId) {
        return compraRepo.findByGranjaIdAndId(granjaId, id);
    }
	
	
	public List<Compra> buscarComprasByGranjaId(Long granjaId){
		return compraRepo.findByGranjaId(granjaId);
		
	}
	
	public Compra getComprasByGranjaIdAndId(Long id, Long granja_id) {
		Compra compra = compraRepo.findByGranjaIdAndId(granja_id, id);
		return compra; 
	} 
	*/
	public Compra getCompraById(Long id) {
		Optional<Compra> compra = compraRepo.findById(id);
		return compra.get();
	} 

	public void agregarCompra(Compra compra) {
		compraRepo.save(compra);
	}

	public void editarCompra(Compra compra) {
		compraRepo.save(compra);
	}

	public void eliminarCompra(Long id) {
		compraRepo.deleteById(id);		
	}
	
	// FIN COMPRAS
	
	
	
	// VENTAS
	
	public List<Venta> obtenerTodasLasVentas() {
		// Aca se instancia al repositorio, es la capa final ya que se consulta a la base de datos
		return ventaRepo.findAll();
	}    
	
	public List<Venta> obtenerTodasMisVentas(Long granja_id) {
		return ventaRepo.findByGranjaId(granja_id);
	}  
	
	public Venta getVentaByIdAndGranjaId(Long id, Long granjaId) {
        return ventaRepo.findByGranjaIdAndId(granjaId, id);
    }
	
	
	
	public List<Venta> buscarVentasByGranjaId(Long granjaId){
		return ventaRepo.findByGranjaId(granjaId);
		
	}

	public Venta buscarVentaById(Long id) {
		Venta venta= ventaRepo.findById(id).orElse(null);
		return venta;
	}
	
	
	public void agregarVenta(Venta venta) {
		ventaRepo.save(venta);
		
	}

	public void editarVenta(Venta venta) {
		ventaRepo.save(venta);
		
	}

	public void eliminarVenta(Long id) {
		ventaRepo.deleteById(id);		
	}    
	
	
	// FIN VENTAS
	
	
	public List<TiposAnimales> actualizarPreciosVenta(double porcentaje) {
		List<TiposAnimales> listaTipos = tiposRepo.findByGranjaId((long)1);
		System.out.println("Nuevos precios: ");
		for(TiposAnimales tipo : listaTipos) {
			double precioActual = tipo.getPrecioVenta();
			precioActual = precioActual * porcentaje; 
			tipo.setPrecioVenta(precioActual);	
			tiposRepo.save(tipo);
		}
		
		listaTipos = tiposRepo.findByGranjaId((long)1);
		for(TiposAnimales tipo : listaTipos) {
			System.out.println(tipo.getAnimal()+" : " + tipo.getPrecioVenta());	
		}
		return listaTipos;
	}
	
/*	private void reproducirGanado() {
	System.out.println("Voy a reproducir Ganado");
	//for(LocalDate i = ultimaActualizacion; i.isBefore(now); i.plusDays(1)) {
	LocalDate i = ultimaActualizacion;
	while( i.isBefore(now)) {
		System.out.println("Fecha de reproduccion: " + i);
		for (Pollito pollito : pollitos) {
			pollito.reproducir(i);
		}
		for (Huevo huevo: huevos) {
			huevo.reproducir(i);
		}
		eliminarExpirados(i);
		 i.plusDays(1);
	}
	
	System.out.println("La ultima fecha de Actualizacion es: " + granjaRepo.findById((long) 1)).get;
}*/
}
