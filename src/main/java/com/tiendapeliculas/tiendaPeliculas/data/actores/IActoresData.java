package com.tiendapeliculas.tiendaPeliculas.data.actores;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tiendapeliculas.tiendaPeliculas.model.Actor;
@Repository
public interface IActoresData extends CrudRepository<Actor, Integer>{

}
