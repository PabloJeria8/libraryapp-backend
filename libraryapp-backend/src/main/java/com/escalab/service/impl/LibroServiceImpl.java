package com.escalab.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.escalab.model.Libro;
import com.escalab.repo.ILibroRepo;
import com.escalab.service.ILibroService;

@Service
public class LibroServiceImpl implements ILibroService {
	
	@Autowired
	private ILibroRepo repo;
	
	@Override
	public Libro registrar(Libro libro) {
		return repo.save(libro);
	}
	
	@Override
	public Libro modificar(Libro libro) {
		return repo.save(libro);
	}
	
	@Override
	public List<Libro> listar() {
		return repo.findAll();
	}
	
	@Override
	public Libro leerPorId(Integer id) {
		Optional<Libro> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Libro();
 	}
	
	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

}
