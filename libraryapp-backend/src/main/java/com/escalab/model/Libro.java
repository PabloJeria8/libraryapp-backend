package com.escalab.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.ForeignKey;

@ApiModel(description = "Información del Libro")
@Entity
@Table(name = "libro")
public class Libro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer IdLibro;
	
	@Column(name = "isbn", nullable = false)
	private Integer isbn;
	
	@ManyToOne
	@JoinColumn(name = "idEditorial", nullable = false, foreignKey = @ForeignKey(name = "FK_libro_editorial"))
	private Editorial editorial;
	
	@ApiModelProperty(notes = "Titulo del libro debe tener mínimo 3 caracteres")
	@Size(min = 3, max = 45, message = "Titulo del libro debe tener mínimo 3 caracteres")
	@Column(name = "titulo", nullable = false, length = 45)
	private String titulo;
	
	@ApiModelProperty(notes = "Sinopsis debe tener mínimo 3 caracteres")
    @Lob @Basic(fetch = FetchType.LAZY) 
	@Size(min = 3, message = "Sinopsis debe tener mínimo 3 caracteres")
	@Column(name = "sinopsis", nullable = true, columnDefinition = "text")
	private String sinopsis;
	
	@Size(max = 45)
	@Column(name = "npaginas", nullable = true, length = 45)
	private String npaginas;

	public Integer getIdLibro() {
		return IdLibro;
	}

	public void setIdLibro(Integer idLibro) {
		IdLibro = idLibro;
	}

	public Integer getIsbn() {
		return isbn;
	}

	public void setIsbn(Integer isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public String getNpaginas() {
		return npaginas;
	}

	public void setNpaginas(String npaginas) {
		this.npaginas = npaginas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((IdLibro == null) ? 0 : IdLibro.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		if (IdLibro == null) {
			if (other.IdLibro != null)
				return false;
		} else if (!IdLibro.equals(other.IdLibro))
			return false;
		return true;
	}

	
}
