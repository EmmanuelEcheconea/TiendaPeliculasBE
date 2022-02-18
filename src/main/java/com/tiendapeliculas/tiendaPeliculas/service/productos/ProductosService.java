package com.tiendapeliculas.tiendaPeliculas.service.productos;

import org.springframework.beans.factory.annotation.Autowired;

import com.tiendapeliculas.tiendaPeliculas.data.peliculas.IPeliculasData;
import com.tiendapeliculas.tiendaPeliculas.data.productos.IProductosData;
import com.tiendapeliculas.tiendaPeliculas.model.Pelicula;
import com.tiendapeliculas.tiendaPeliculas.model.Producto;
import com.tiendapeliculas.tiendaPeliculas.model.enums.EstadoProductoEnum;

public class ProductosService {

	@Autowired
	private IProductosData productosData;
	@Autowired
	private IPeliculasData peliculaData;

	public byte insertarProducto(int idPelicula) {
		try {
			Pelicula pelicula = peliculaData.findById(idPelicula).get();
			if (pelicula != null) {
				/*
				 * TODO:falta asignar los valores correspondientes al producto el numer del
				 * carro y usuario luego
				 */
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

	public byte borrarProducto(int idPelicula) {
		try {
			Producto producto = productosData.findProductoByIdCarritoAndByIdPelicula(1, idPelicula,
					EstadoProductoEnum.SELECCIONADO.toString());
			if (producto != null) {

				productosData.delete(producto);
				return 1;
			}
			return 0;
		} catch (Exception e) {
			System.out.println(e);
			return -1;
		}
	}
}
