package com.tiendapeliculas.tiendaPeliculas.data.productos;

import org.springframework.data.repository.CrudRepository;

import com.tiendapeliculas.tiendaPeliculas.model.Producto;

public interface IProductosData extends CrudRepository<Producto, Integer>{

}
