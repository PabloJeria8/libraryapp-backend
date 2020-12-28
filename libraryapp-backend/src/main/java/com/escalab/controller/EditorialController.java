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
import com.escalab.model.Editorial;
import com.escalab.service.IEditorialService;

@RestController
@RequestMapping("/editoriales")
public class EditorialController {
	
	@Autowired
	private IEditorialService service;
	
	@GetMapping
	public ResponseEntity<List<Editorial>> listar() {
		List<Editorial> lista = service.listar();
		return new ResponseEntity<List<Editorial>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Editorial> listarPorId(@PathVariable("id") Integer id) {
		Editorial edi = service.leerPorId(id);
		if (edi.getIdEditorial() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
		}
		return new ResponseEntity<Editorial>(edi, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Editorial editorial) {
		Editorial edi = service.registrar(editorial);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(editorial.getIdEditorial()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Editorial> modificar(@Valid @RequestBody Editorial editorial) {
		Editorial edi = service.modificar(editorial);
		return new ResponseEntity<Editorial>(edi, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Editorial edi = service.leerPorId(id);
		if (edi.getIdEditorial() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}

}
