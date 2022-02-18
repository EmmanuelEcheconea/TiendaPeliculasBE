package com.tiendapeliculas.tiendaPeliculas.data.productos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tiendapeliculas.tiendaPeliculas.model.Producto;

public interface IProductosData extends CrudRepository<Producto, Integer>{
	
	@Query("SELECT * FROM productos where idPelicula = :idPelicula and idCarrito = :idCarrito and estadoProducto = :estadoProducto")
	public Producto findProductoByIdCarritoAndByIdPelicula(@Param("idCarrito") int idCarrito,
			@Param("idPelicula") int idPelicula, @Param("estadoProducto") String estadoProducto);
}
