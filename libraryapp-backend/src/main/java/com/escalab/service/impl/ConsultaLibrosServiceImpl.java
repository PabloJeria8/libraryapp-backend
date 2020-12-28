package com.escalab.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.escalab.dto.ConsultaListaLibrosDTO;
import com.escalab.dto.FiltroLibroDTO;
import com.escalab.model.Autor;
import com.escalab.model.ConsultaLibros;
import com.escalab.repo.IConsultaLibrosRepo;
import com.escalab.service.IConsultaLibrosService;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ConsultaLibrosServiceImpl implements IConsultaLibrosService {

	@Autowired
	private IConsultaLibrosRepo repo;
	
	@Override
	public List<ConsultaLibros> buscarporNombreLibro(FiltroLibroDTO filtro) {
		return repo.buscarLibrosporNombre(filtro.getNombreLibro());
	}

	@Override
	public List<ConsultaLibros> buscarporNombreAutor(FiltroLibroDTO filtro) {
		return repo.buscarLibrosporAutor(filtro.getNombreAutor());
	}
	
	@Transactional
	@Override 
	public Autor registrarTransaccional(ConsultaListaLibrosDTO dto) { 

		dto.getLstLibros().forEach(ex -> repo.registrar(dto.getAutor().getIdAutor(), ex.getIdLibro()));

		return dto.getAutor();
	}

}
