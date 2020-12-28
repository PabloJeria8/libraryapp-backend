package com.escalab.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "consulta_libros")
@IdClass(ConsultaLibrosPK.class)
public class ConsultaLibros {
	
	@Id
	private Autor autor;
	
	@Id
	private Libro libro;

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	

}
