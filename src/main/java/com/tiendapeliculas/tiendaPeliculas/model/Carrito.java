package com.tiendapeliculas.tiendaPeliculas.model;

import com.tiendapeliculas.tiendaPeliculas.model.enums.EstadoCarritoEnum;

public class Carrito {

	private long id;
	private long idUsuario;
	private EstadoCarritoEnum estado;
	
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
	public EstadoCarritoEnum getEstado() {
		return estado;
	}
	public void setEstado(EstadoCarritoEnum estado) {
		this.estado = estado;
	}
	
	
}
