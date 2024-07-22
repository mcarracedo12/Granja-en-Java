package com.accenture.granja.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.granja.exceptions.NoContentException;
import com.accenture.granja.model.Animal;
import com.accenture.granja.model.Compra;
import com.accenture.granja.model.Granja;
import com.accenture.granja.model.TiposAnimales;
import com.accenture.granja.model.Usuario;
import com.accenture.granja.model.Venta;
import com.accenture.granja.services.AnimalService;
import com.accenture.granja.services.CompraService;
import com.accenture.granja.services.GranjaService;
import com.accenture.granja.services.TiposService;
import com.accenture.granja.services.UsuarioService;
import com.accenture.granja.services.VentaService;

@RestController
@RequestMapping("/granja")
@CrossOrigin(origins = "http://localhost:4200") 
public class GranjaController {

	@Autowired
	private GranjaService granjaService;
	@Autowired
	private TiposService tiposService;
	@Autowired
	private AnimalService animalService;
	@Autowired
	private CompraService compraService;
	@Autowired
	private VentaService ventaService;
	@Autowired
	private UsuarioService usuarioService;

	// INICIO GRANJAS
	@GetMapping("/")
	@ResponseBody
	public ResponseEntity<List<Granja>> getGranjas() {
		List<Granja> granjas = granjaService.buscarGranjas();
		return new ResponseEntity<>(granjas, HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Granja> getGranjaDetails(@PathVariable Long id) {
		Granja granja = granjaService.buscarGranja(id);
		return new ResponseEntity<>(granja, HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<Granja> createGranja(@RequestBody Granja granja) {
		granjaService.agregarGranja(granja); // la granja no necesita tener ID para el POST
		return new ResponseEntity<Granja>(granja, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Granja> updateGranja(@RequestBody Granja granja, @PathVariable Long id) {
		Granja updatedGranja = granjaService.editarGranja(granja, id); //  la granja SI necesita tener el ID para el PUT
		return new ResponseEntity<>(updatedGranja, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteGranja(@PathVariable Long id) {
		granjaService.eliminarGranja(id); 
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	//INICIO TIPO
	
	@GetMapping("/{granja_id}/tipos")
	public ResponseEntity<List<TiposAnimales>> getTiposAnimales(@PathVariable Long granja_id) {
		List<TiposAnimales> tipos = tiposService.obtenerTodosLosTiposAnimalesByGranja(granja_id);
		return new ResponseEntity<>(tipos, HttpStatus.OK);
	}

	@GetMapping("/{granja_id}/tipos/{id}")
	public ResponseEntity<TiposAnimales> getTipoDetails(@PathVariable Long id, @PathVariable Long granja_id) {
		TiposAnimales tipo = tiposService.getByGranjaIdAndId(id, granja_id);
		return ResponseEntity.ok(tipo);
	}
	
	@PostMapping("/{granja_id}/tipos")
	public ResponseEntity<TiposAnimales> createTipoAnimal(@PathVariable Long granja_id,  @RequestBody TiposAnimales tipo) {
		Granja granja = granjaService.buscarGranja(granja_id);
		  if (granja == null) {
		         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		     }
		tipo.setGranja(granja);
		TiposAnimales createdTipo = tiposService.agregarTipo(tipo); 
		return new ResponseEntity<>(createdTipo, HttpStatus.CREATED);
	}
	
	@PutMapping("/{granja_id}/tipos/{id}")
	public ResponseEntity<TiposAnimales> updateTipos(@RequestBody TiposAnimales tipo,@PathVariable Long granja_id, @PathVariable Long id) {
		TiposAnimales updatedTipo = tiposService.editarTipo(tipo, granja_id, id); 
		return new ResponseEntity<>(updatedTipo, HttpStatus.OK);
	}

	@DeleteMapping("/{granja_id}/tipos/{id}")
	public ResponseEntity<Void> deleteTipo(@PathVariable Long granja_id,@PathVariable Long id) {
		tiposService.eliminarTipo(id, granja_id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	// ANIMALES
	
	@GetMapping("/{granja_id}/tipos/{tiposAnimales_id}/animales")
	public ResponseEntity<List<Animal>> getAnimalesByTipo(@PathVariable Long granja_id, @PathVariable Long tiposAnimales_id) {
	    List<Animal> animales = animalService.getAnimalByTipoId(granja_id, tiposAnimales_id);
	    if (animales.isEmpty()) {
	        throw new NoContentException("No hay animales del tipo " + tiposAnimales_id + " en la granja " + granja_id);
	    }
	    return ResponseEntity.ok(animales);
	}

	@GetMapping("/{granja_id}/tipos/{tiposAnimales_id}/animales/{id}")
	public ResponseEntity<Animal> getAnimalById(@PathVariable Long granja_id, @PathVariable Long tiposAnimales_id,
	                                            @PathVariable Long id) throws Exception {
	    Optional<Animal> animalOptional = Optional.ofNullable(animalService.getAnimalById(id));
	    if (!animalOptional.isPresent()) {
	        throw new NoContentException("No hay animales del tipo " + tiposAnimales_id + " en la granja " + granja_id);
	    }
	    Animal animal = animalOptional.get();
	    if (!animal.getGranja().getId().equals(granja_id)) {
	        throw new Exception("No tiene acceso a esta granja");
	    }
	    if (!animal.getTiposAnimales().getId().equals(tiposAnimales_id)) {
	        throw new Exception("El animal no corresponde a este tipo");
	    }
	    return ResponseEntity.ok(animal);
	}
	
	@PostMapping("/{granja_id}/tipos/{tiposAnimales_id}/animales/{cantidad}")
	public ResponseEntity<List<Animal>> createAnimal(@PathVariable Long granja_id, @PathVariable Long tiposAnimales_id, @PathVariable Long cantidad,
			@RequestBody Animal animal) {
		Granja granja = granjaService.buscarGranja(granja_id);
		List<Animal> animales = new ArrayList<Animal>();
		for (int cant = 0; cant < cantidad; cant++) {
			animal.setGranja(granja);
			animal.setFechaIngresoAGranja(LocalDate.now());
			animal.setNacimiento(animal.getFechaIngresoAGranja().plusDays(animal.getEdadEnDiasAlIngresar()));
			animalService.agregarAnimal(animal, tiposAnimales_id);
			animales.add(animal);
		}
		return new ResponseEntity<>(animales, HttpStatus.CREATED);
	}
	
	@PostMapping("/{granja_id}/tipos/{tiposAnimales_id}/animales")
	public  ResponseEntity<Animal> createAnimal(@PathVariable Long tiposAnimales_id, @RequestBody Animal animal) {
		animalService.agregarAnimal(animal, tiposAnimales_id);
		return new ResponseEntity<>(animal, HttpStatus.CREATED);
	}
	@PutMapping("/{granja_id}/animales/{id}")
	public ResponseEntity<Animal> updateAnimal(@RequestBody Animal animal, @PathVariable Long id, @PathVariable Long granja_id) {
	    Animal existingAnimal = animalService.getAnimalById(id);
	    if (existingAnimal == null) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	    if (!existingAnimal.getGranja().getId().equals(granja_id)) {
	        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	    }
	    animal.setId(id);
	    animalService.editarAnimal(animal);
	    return new ResponseEntity<>(animal, HttpStatus.OK);
	}
	@DeleteMapping("/{granja_id}/animales/{id}")
	public ResponseEntity<Void> deleteAnimal(@PathVariable Long granja_id, @PathVariable Long id) {
		 Animal animal = animalService.getAnimalById(id);
		    if (animal == null) {
		        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }
		    if (!animal.getGranja().getId().equals(granja_id)) {
		        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		    }
		animalService.eliminarAnimal(id);
		 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	// COMPRAS
	
	@GetMapping("/{granja_id}/compras")
	public ResponseEntity<List<Compra>> getComprasMisCompras(@PathVariable Long granja_id) {
		List<Compra> compras =  compraService.buscarComprasByGranjaId(granja_id);
		if(compras == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(compras, HttpStatus.OK);
	}
	
	@GetMapping("/{granja_id}/compras/{id}")
	public ResponseEntity<Compra> getCompraDetails(@PathVariable Long id, @PathVariable Long granja_id) {
	    Optional<Compra> compraOptional = Optional.ofNullable(compraService.getCompraByIdAndGranjaId(id, granja_id));
	    return compraOptional.filter(compra -> compra.getGranja().getId().equals(granja_id))
	                         .map(compra -> new ResponseEntity<>(compra, HttpStatus.OK))
	                         .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	 @GetMapping("/{granja_id}/compras/{id}/productos")
		public ResponseEntity<List<Animal>> getProductosCompradosDetails(@PathVariable Long id, @PathVariable Long granja_id ) {
			List<Animal>  productos ;
			Optional <Compra> compra = Optional.of(compraService.getComprasByGranjaIdAndId(id, granja_id));
			productos= ResponseEntity.ok(compra).getBody().get().getProductosComprados();
	        return new ResponseEntity<>(productos, HttpStatus.OK);
	}

	 @PostMapping("/{granja_id}/compras")
	 public ResponseEntity<Compra> createCompra(@PathVariable Long granja_id, @RequestBody Compra compra) {
	     Granja granja = granjaService.buscarGranja(granja_id);
	     if (granja == null) {
	         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	     }
	     compra.setGranja(granja);
	     Compra createdCompra =  compraService.agregarCompra(compra);
	     return new ResponseEntity<>(createdCompra, HttpStatus.CREATED);
	 }

	
	@PostMapping("/{granja_id}/compras/{id}/productos")
	public ResponseEntity<Compra> agregarProducto(@RequestBody List<Animal> productos,@PathVariable Long granja_id, @PathVariable Long id) {
		Compra compra = compraService.getComprasByGranjaIdAndId(granja_id, id);
		 if (compra == null) {
		        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }else {
		    	for(Animal p : productos) {
					p.setCompra(compra);
				}
				return new ResponseEntity<>(compra, HttpStatus.OK);
		    }
		
	}
	
	
	@PutMapping("/{granja_id}/compras/{id}")
	public ResponseEntity<Compra> updateCompra(@RequestBody Compra compra,
	                                           @PathVariable Long granja_id,
	                                           @PathVariable Long id) {
	    Compra existingCompra = compraService.getCompraByIdAndGranjaId(id, granja_id);
	    if (existingCompra == null) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	    existingCompra.setFecha(compra.getFecha());
	    existingCompra.setNombrePersona(compra.getNombrePersona());
	    compraService.editarCompra(existingCompra);
	    return new ResponseEntity<>(existingCompra, HttpStatus.OK);
	}


	
	@DeleteMapping("/{granja_id}/compras/{id}")
	public void deleteCompra(@PathVariable Long granja_id,
            @PathVariable Long id) {
		Compra compra = compraService.getCompraByIdAndGranjaId(id, granja_id);
		 if (compra == null) {
		        throw new NoContentException("La compra no fue encontrada con el id: " + id);
		    }
		compraService.eliminarCompra(id);
	}
	

	// VENTAS 
	
	@GetMapping("/{granja_id}/ventas")
	public ResponseEntity<List<Venta>> getVentasMisVentas(@PathVariable Long granja_id) {
		List<Venta> ventas =  ventaService.buscarVentasByGranjaId(granja_id);
		if(ventas == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(ventas, HttpStatus.OK);
	}
	
	@GetMapping("/{granja_id}/ventas/{id}")
	public ResponseEntity<Venta> getVentaDetails(@PathVariable Long id, @PathVariable Long granja_id) {
	    Optional<Venta> ventaOptional = Optional.ofNullable(ventaService.getVentaByIdAndGranjaId(id, granja_id));
	    return ventaOptional.filter(venta -> venta.getGranja().getId().equals(granja_id))
	                         .map(venta -> new ResponseEntity<>(venta, HttpStatus.OK))
	                         .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	 @GetMapping("/{granja_id}/ventas/{id}/productos")
		public ResponseEntity<List<Animal>> getProductosVendidosDetails(@PathVariable Long id, @PathVariable Long granja_id ) {
			List<Animal> productos ;
			Optional <Venta> venta = Optional.of(ventaService.getVentaByIdAndGranjaId(id, granja_id));
			productos= ResponseEntity.ok(venta).getBody().get().getProductosVendidos();
	        return new ResponseEntity<>(productos, HttpStatus.OK);
	}

	 @PostMapping("/{granja_id}/ventas")
	 public ResponseEntity<Venta> createVenta(@PathVariable Long granja_id, @RequestBody Venta venta) {
	     Granja granja = granjaService.buscarGranja(granja_id);
	     if (granja == null) {
	         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	     }
	     venta.setGranja(granja);
	     Venta createdVenta = ventaService.agregarVenta(venta);
	     return new ResponseEntity<>(createdVenta, HttpStatus.CREATED);
	 }

	
	@PostMapping("/{granja_id}/ventas/{id}/productos")
	public ResponseEntity<Venta> agregarProductoVendido(@RequestBody List<Animal> productos,@PathVariable Long granja_id, @PathVariable Long id) {
		Venta venta = ventaService.getVentaByIdAndGranjaId(id, granja_id);
		 if (venta == null) {
		        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }
		for(Animal p : productos) {
			p.setVenta(venta);
		}
		return new ResponseEntity<>(venta, HttpStatus.OK);
	}
	
	
	@PutMapping("/{granja_id}/ventas/{id}")
	public ResponseEntity<Venta> updateVenta(@RequestBody Venta venta,
	                                           @PathVariable Long granja_id,
	                                           @PathVariable Long id) {
		Venta existingVenta = ventaService.getVentaByIdAndGranjaId(id, granja_id);
	    if (existingVenta == null) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	    //existingVenta.setFecha(venta.getFecha());
	    //existingVenta.setNombrePersona(compra.getNombrePersona());
	    ventaService.editarVenta(existingVenta);
	    return new ResponseEntity<>(existingVenta, HttpStatus.OK);
	}

	@DeleteMapping("/{granja_id}/ventas/{id}")
	public void deleteVenta(@PathVariable Long granja_id,
            @PathVariable Long id) {
		Venta venta = ventaService.getVentaByIdAndGranjaId(id, granja_id);
		 if (venta == null) {
		        throw new NoContentException("La venta no fue encontrada con el id: " + id);
		    }
		ventaService.eliminarVenta(id);
	}
	
	// USUARIOS
	
	@GetMapping("/{granja_id}/usuarios")
	public ResponseEntity<List<Usuario>> getUsuarios(@PathVariable Long granja_id) {
		List<Usuario> usuarios = usuarioService.buscarUsuariosByGranja(granja_id);
		return new ResponseEntity<>(usuarios, HttpStatus.OK);
	}
/*
	@PostMapping("/")
	public ResponseEntity<Granja> createGranja(@RequestBody Granja granja) {
		granjaService.agregarGranja(granja); // la granja no necesita tener ID para el POST
		return new ResponseEntity<Granja>(granja, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Granja> updateGranja(@RequestBody Granja granja, @PathVariable Long id) {
		Granja updatedGranja = granjaService.editarGranja(granja, id); //  la granja SI necesita tener el ID para el PUT
		return new ResponseEntity<>(updatedGranja, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteGranja(@PathVariable Long id) {
		granjaService.eliminarGranja(id); 
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
*/
}
