package com.escalab.dto;

import java.util.List;
import com.escalab.model.Autor;
import com.escalab.model.Libro;

public class ConsultaListaLibrosDTO {
	
	private Autor autor;
	private List<Libro> lstLibros;
	
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	public List<Libro> getLstLibros() {
		return lstLibros;
	}
	public void setLstLibros(List<Libro> lstLibros) {
		this.lstLibros = lstLibros;
	}

}
