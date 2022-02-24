package com.tiendapeliculas.tiendaPeliculas.data.generos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tiendapeliculas.tiendaPeliculas.model.Genero;
@Repository
public interface IGenerosData extends CrudRepository<Genero, Long>{

}
