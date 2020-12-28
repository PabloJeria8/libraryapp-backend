package com.escalab.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.escalab.model.Autor;
import com.escalab.repo.IAutorRepo;
import com.escalab.service.IAutorService;

@Service
public class AutorServiceImpl implements IAutorService {
	
	@Autowired
	private IAutorRepo repo;
	
	@Override
	public Autor registrar(Autor autor) {
		return repo.save(autor);
	}
	
	@Override
	public Autor modificar(Autor autor) {
		return repo.save(autor);
	}
	
	@Override
	public List<Autor> listar() {
		return repo.findAll();
	}
	
	@Override
	public Autor leerPorId(Integer id) {
		Optional<Autor> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Autor();
 	}
	
	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

}
