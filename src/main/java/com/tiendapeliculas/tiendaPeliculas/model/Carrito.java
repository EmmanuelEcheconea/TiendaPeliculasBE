package com.tiendapeliculas.tiendaPeliculas.model;

import javax.persistence.Entity;


@Entity
public class Carrito {

	private long id;
	private long idUsuario;
	private String estado;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
