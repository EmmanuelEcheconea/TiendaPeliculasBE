package com.tiendapeliculas.tiendaPeliculas.data.peliculas;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tiendapeliculas.tiendaPeliculas.model.Pelicula;

@Repository
public interface IPeliculasData extends CrudRepository<Pelicula, Long> {

}
