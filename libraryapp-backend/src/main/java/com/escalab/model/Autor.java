package com.escalab.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Información del Autor")
@Entity
@Table(name = "autor")
public class Autor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer IdAutor;
	
	@ApiModelProperty(notes = "Nombres debe tener minimo 3 caracteres")
	@Size(min = 3, max = 45, message = "Nombres debe tener mínimo 3 caracteres")
	@Column(name = "nombres", nullable = false, length = 45)
	private String nombres;
	
	@ApiModelProperty(notes = "Apellidos debe tener minimo 3 caracteres")
	@Size(min = 3, max = 45, message = "Apellidos debe tener mínimo 3 caracteres")
	@Column(name = "apellidos", nullable = false, length = 45)
	private String apellidos;

	public Integer getIdAutor() {
		return IdAutor;
	}

	public void setIdAutor(Integer idAutor) {
		IdAutor = idAutor;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((IdAutor == null) ? 0 : IdAutor.hashCode());
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
		Autor other = (Autor) obj;
		if (IdAutor == null) {
			if (other.IdAutor != null)
				return false;
		} else if (!IdAutor.equals(other.IdAutor))
			return false;
		return true;
	}
	
	
}
