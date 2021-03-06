package com.tiendapeliculas.tiendaPeliculas.data.productos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tiendapeliculas.tiendaPeliculas.model.Producto;
@Repository
public interface IProductosData extends CrudRepository<Producto, Integer>{
	
	@Query(value="SELECT * FROM productos where idPelicula = :idPelicula and idCarrito = :idCarrito and estadoProducto = :estadoProducto", nativeQuery = true)
	public Producto findProductoByIdCarritoAndByIdPelicula(@Param("idCarrito") int idCarrito,
			@Param("idPelicula") int idPelicula, @Param("estadoProducto") String estadoProducto);
}
