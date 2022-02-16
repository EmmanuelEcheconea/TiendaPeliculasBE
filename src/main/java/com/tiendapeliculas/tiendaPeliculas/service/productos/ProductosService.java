package com.tiendapeliculas.tiendaPeliculas.service.productos;

import org.springframework.beans.factory.annotation.Autowired;

import com.tiendapeliculas.tiendaPeliculas.data.peliculas.IPeliculasData;
import com.tiendapeliculas.tiendaPeliculas.data.productos.IProductosData;
import com.tiendapeliculas.tiendaPeliculas.model.Pelicula;
import com.tiendapeliculas.tiendaPeliculas.model.Producto;

public class ProductosService {

	@Autowired
	private IProductosData productosData;
	@Autowired
	private IPeliculasData peliculaData;

	public byte insertarProducto(int idPelicula) {
		try {
			Pelicula pelicula = peliculaData.findById(idPelicula).get();
			if (pelicula != null) {

				Producto producto = new Producto();
				productosData.save(producto);
				return 1;
			}
			return 0;
		} catch (Exception e) {
			System.out.println(e);
			return -1;
		}
	}
}
