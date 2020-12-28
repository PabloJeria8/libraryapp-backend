package com.escalab.controller;

import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.escalab.exception.ModeloNotFoundException;
import com.escalab.model.Libro;
import com.escalab.service.ILibroService;

@RestController
@RequestMapping("/libros")
public class LibroController {
	
	@Autowired
	private ILibroService service;
	
	@PreAuthorize("@authServiceImpl.tieneAcceso('listar')")
	//@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('DBA')")
	@GetMapping
	public ResponseEntity<List<Libro>> listar() {
		List<Libro> lista = service.listar();
		return new ResponseEntity<List<Libro>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Libro> listarPorId(@PathVariable("id") Integer id) {
		Libro lib = service.leerPorId(id);
		if (lib.getIdLibro() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
		}
		return new ResponseEntity<Libro>(lib, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Libro libro) {
		Libro lib = service.registrar(libro);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(libro.getIdLibro()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Libro> modificar(@Valid @RequestBody Libro libro) {
		Libro lib = service.modificar(libro);
		return new ResponseEntity<Libro>(lib, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Libro lib = service.leerPorId(id);
		if (lib.getIdLibro() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

}
