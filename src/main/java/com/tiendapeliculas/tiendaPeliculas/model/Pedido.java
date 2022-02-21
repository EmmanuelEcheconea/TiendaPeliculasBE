package com.tiendapeliculas.tiendaPeliculas.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pedido {
	@Id
	private long id;
	private long idCarrito;
	private long idUsuario;
	private String estado;
	private Date fechaDeCambioDeEstado;
	private Date fechaGenerada;
	private double precioTotal;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getIdCarrito() {
		return idCarrito;
	}
	public void setIdCarrito(long idCarrito) {
		this.idCarrito = idCarrito;
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
	public Date getFechaDeCambioDeEstado() {
		return fechaDeCambioDeEstado;
	}
	public void setFechaDeCambioDeEstado(Date fechaDeCambioDeEstado) {
		this.fechaDeCambioDeEstado = fechaDeCambioDeEstado;
	}
	public Date getFechaGenerada() {
		return fechaGenerada;
	}
	public void setFechaGenerada(Date fechaGenerada) {
		this.fechaGenerada = fechaGenerada;
	}
	public double getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}
}
