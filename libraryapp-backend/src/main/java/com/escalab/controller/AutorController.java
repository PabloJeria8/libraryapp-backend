package com.escalab.controller;

import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.escalab.model.Autor;
import com.escalab.service.IAutorService;

@RestController
@RequestMapping("/autores")
public class AutorController {
	
	@Autowired 
	private IAutorService service;
	
	@GetMapping
	public ResponseEntity<List<Autor>> listar() {
		List<Autor> lista = service.listar();
		return new ResponseEntity<List<Autor>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Autor> listarPorId(@PathVariable("id") Integer id) {
		Autor aut = service.leerPorId(id);
		if (aut.getIdAutor() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
		}
		return new ResponseEntity<Autor>(aut, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Autor autor) {
		Autor aut = service.registrar(autor);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(autor.getIdAutor()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Autor> modificar(@Valid @RequestBody Autor autor) {
		Autor aut = service.modificar(autor);
		return new ResponseEntity<Autor>(aut, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Autor aut = service.leerPorId(id);
		if (aut.getIdAutor() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	

}
