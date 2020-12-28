package com.escalab.service;

import java.util.List;
import com.escalab.dto.ConsultaListaLibrosDTO;
import com.escalab.dto.FiltroLibroDTO;
import com.escalab.model.Autor;
import com.escalab.model.ConsultaLibros;

public interface IConsultaLibrosService{
	
	Autor registrarTransaccional(ConsultaListaLibrosDTO dto);
	
	List<ConsultaLibros> buscarporNombreLibro(FiltroLibroDTO filtro);
	  
	List<ConsultaLibros> buscarporNombreAutor(FiltroLibroDTO filtro);
	
}
