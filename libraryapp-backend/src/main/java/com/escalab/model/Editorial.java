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

@ApiModel(description = "Información de la Editorial")
@Entity
@Table(name = "editorial")
public class Editorial {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEditorial;
	
	@ApiModelProperty(notes = "Nombre de la editorial debe tener mínimo 3 caracteres")
	@Size(min = 3, max = 45, message = "Nombre de la editorial debe tener mínimo 3 caracteres")
	@Column(name = "nombre", nullable = false, length = 45)
	private String nombre;
	
	@ApiModelProperty(notes = "Sede de la editorial debe tener mínimo 3 caracteres")
	@Size(min = 3, max = 45, message = "Sede de la editorial debe tener mínimo 3 caracteres")
	@Column(name = "sede", nullable = false, length = 45)
	private String sede;

	public Integer getIdEditorial() {
		return idEditorial;
	}

	public void setIdEditorial(Integer idEditorial) {
		this.idEditorial = idEditorial;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}


}
