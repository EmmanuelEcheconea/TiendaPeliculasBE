package com.tiendapeliculas.tiendaPeliculas.model;

public class Producto {

	private long id;
	private long idPelicula;
	private long idCarrito;
	private long idFactura;
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
	public long getIdFactura() {
		return idFactura;
	}
	public void setIdFactura(long idFactura) {
		this.idFactura = idFactura;
	}
	public long getCantidad() {
		return cantidad;
	}
	public void setCantidad(long cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
