package com.tiendapeliculas.tiendaPeliculas.data.usuarios;

import org.springframework.data.repository.CrudRepository;

import com.tiendapeliculas.tiendaPeliculas.model.Usuario;

public interface IUsuariosData extends CrudRepository<Usuario, Integer>{

}
