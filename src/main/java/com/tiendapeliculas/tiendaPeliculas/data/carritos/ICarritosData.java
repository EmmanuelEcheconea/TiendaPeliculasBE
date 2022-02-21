package com.tiendapeliculas.tiendaPeliculas.data.carritos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tiendapeliculas.tiendaPeliculas.model.Carrito;
@Repository
public interface ICarritosData extends CrudRepository<Carrito, Integer> {

}
