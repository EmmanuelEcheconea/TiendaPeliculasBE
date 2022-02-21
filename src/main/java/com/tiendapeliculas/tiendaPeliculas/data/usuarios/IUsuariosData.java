package com.tiendapeliculas.tiendaPeliculas.data.usuarios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tiendapeliculas.tiendaPeliculas.model.Usuario;
@Repository
public interface IUsuariosData extends CrudRepository<Usuario, Integer>{

}
