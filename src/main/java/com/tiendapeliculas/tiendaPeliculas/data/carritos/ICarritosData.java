package com.tiendapeliculas.tiendaPeliculas.data.carritos;

import org.springframework.data.repository.CrudRepository;

import com.tiendapeliculas.tiendaPeliculas.model.Carrito;

public interface ICarritosData extends CrudRepository<Carrito, Integer> {

}
