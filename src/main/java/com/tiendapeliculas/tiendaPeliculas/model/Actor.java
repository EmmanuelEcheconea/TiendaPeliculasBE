package com.tiendapeliculas.tiendaPeliculas.model;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Actor {

	private long id;
	private String nombre;
	private String apellido;
	private int edad;
	private String nacionalidad;
	private Date fechaDeNacimiento;
	private Date fechaDeMuerte;
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
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public Date getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}
	public void setFechaDeNacimiento(Date fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	public Date getFechaDeMuerte() {
		return fechaDeMuerte;
	}
	public void setFechaDeMuerte(Date fechaDeMuerte) {
		this.fechaDeMuerte = fechaDeMuerte;
	}
	
	
}
