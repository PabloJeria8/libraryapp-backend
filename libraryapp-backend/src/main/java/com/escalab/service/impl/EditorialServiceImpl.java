package com.escalab.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.escalab.model.Editorial;
import com.escalab.repo.IEditorialRepo;
import com.escalab.service.IEditorialService;

@Service
public class EditorialServiceImpl implements IEditorialService { 
	
	@Autowired
	private IEditorialRepo repo;
	
	@Override
	public Editorial registrar(Editorial editorial) {
		return repo.save(editorial);
	}
	
	@Override
	public Editorial modificar(Editorial editorial) {
		return repo.save(editorial);
	}
	
	@Override
	public List<Editorial> listar() {
		return repo.findAll();
	}
	
	@Override
	public Editorial leerPorId(Integer id) {
		Optional<Editorial> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Editorial();
 	}
	
	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

}
