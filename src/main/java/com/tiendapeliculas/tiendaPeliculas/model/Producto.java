package com.tiendapeliculas.tiendaPeliculas.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Producto {
	@Id
	private long id;
	private long idPelicula;
	private long idCarrito;
	private long idPedido;
	private long idUsuario;
	private String estado;
	private long cantidad;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getIdPelicula() {
		return idPelicula;
	}
	public void setIdPelicula(long idPelicula) {
		this.idPelicula = idPelicula;
	}
	public long getIdCarrito() {
		return idCarrito;
	}
	public void setIdCarrito(long idCarrito) {
		this.idCarrito = idCarrito;
	}
	public long getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(long idPedido) {
		this.idPedido = idPedido;
	}
	public long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getEstadoProducto() {
		return estado;
	}
	public void setEstadoProducto(String estado) {
		this.estado = estado;
	}
	public long getCantidad() {
		return cantidad;
	}
	public void setCantidad(long cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
