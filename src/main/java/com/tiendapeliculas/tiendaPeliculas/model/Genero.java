package com.tiendapeliculas.tiendaPeliculas.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Genero {
	@Id
	private long id;
	private String nombre;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
