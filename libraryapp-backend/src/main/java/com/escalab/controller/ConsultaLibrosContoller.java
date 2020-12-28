package com.escalab.controller;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.escalab.dto.ConsultaListaLibrosDTO;
import com.escalab.dto.FiltroLibroDTO;
import com.escalab.model.Archivo;
import com.escalab.model.Autor;
import com.escalab.model.ConsultaLibros;
import com.escalab.service.IArchivoService;
import com.escalab.service.IConsultaLibrosService;

@RestController
@RequestMapping("/consultaslibros")
public class ConsultaLibrosContoller {

	@Autowired
	private IConsultaLibrosService service;

	@Autowired
	private IArchivoService serviceArchivo;
	
	@PostMapping("/buscarpornombrelibro") 
	public ResponseEntity<List<ConsultaLibros>> buscarporNombreLibro(@RequestBody FiltroLibroDTO filtro) { 
		List<ConsultaLibros> libros = new ArrayList<>();

		if (filtro != null) { 
			if (filtro.getNombreLibro() != null) { 
				libros = service.buscarporNombreLibro(filtro); 
				} 
			} 
		
		return new ResponseEntity<List<ConsultaLibros>>(libros, HttpStatus.OK); 
	}
	
	@PostMapping("/buscarpornombreautor") 
	public ResponseEntity<List<ConsultaLibros>> buscarporNombreAutor(@RequestBody FiltroLibroDTO filtro) { 
		List<ConsultaLibros> libros = new ArrayList<>();

		if (filtro != null) { 
			if (filtro.getNombreAutor() != null) { 
				libros = service.buscarporNombreAutor(filtro);
				} 
			} 
		
		return new ResponseEntity<List<ConsultaLibros>>(libros, HttpStatus.OK); 
	}

	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody ConsultaListaLibrosDTO consultalistalibrosDTO) {
		Autor obj = service.registrarTransaccional(consultalistalibrosDTO);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdAutor()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	
	@PostMapping(value = "/guardarArchivo", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
	public ResponseEntity<Integer> guardarArchivo(@RequestParam("adjunto") MultipartFile file) throws IOException{
		int rpta = 0;
		Archivo ar = new Archivo();
		ar.setFiletype(file.getContentType());
		ar.setFilename(file.getName());
		ar.setValue(file.getBytes());

		rpta = serviceArchivo.guardar(ar);

		return new ResponseEntity<Integer>(rpta, HttpStatus.OK);	
	}

	@GetMapping(value = "/leerArchivo/{idArchivo}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<byte[]> leerArchivo(@PathVariable("idArchivo") Integer idArchivo) throws IOException {

		byte[] arr = serviceArchivo.leerArchivo(idArchivo); 

		return new ResponseEntity<byte[]>(arr, HttpStatus.OK);
	}

}
