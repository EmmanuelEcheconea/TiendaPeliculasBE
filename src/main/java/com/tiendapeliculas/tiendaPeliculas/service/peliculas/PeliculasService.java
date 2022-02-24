package com.tiendapeliculas.tiendaPeliculas.service.peliculas;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiendapeliculas.tiendaPeliculas.data.peliculas.IPeliculasData;
import com.tiendapeliculas.tiendaPeliculas.model.Pelicula;

@Service
public class PeliculasService {

	@Autowired
	private IPeliculasData peliculaData;

	public List<Pelicula> obtenerPeliculas() {
		return (List<Pelicula>) peliculaData.findAll();
	}

	public Pelicula obtenerPelicula(int id) {
		Optional<Pelicula> pelicula = peliculaData.findById((long)id);
		if (pelicula.isPresent()) {
			return pelicula.get();
		}
		return null;
	}

	public byte insertarPelicula(Pelicula pelicula) {
		try {
			peliculaData.save(pelicula);
			return 1;
		} catch (Exception e) {
			System.out.println(e);
			return -1;
		}
	}

	public byte borrarPelicula(int id) {
		try {
			Optional<Pelicula> pelicula = peliculaData.findById((long)id);
			if (pelicula.isPresent()) {
				peliculaData.delete(pelicula.get());
				return 1;
			}
			return 0;
		} catch (Exception e) {
			System.out.println(e);
			return -1;
		}
	}

	public byte actualizarPelicula(int id, Pelicula pelicula) {
		try {
			Optional<Pelicula> resultado = peliculaData.findById((long)id);
			if (resultado.isPresent()) {
				resultado.get().setCalificacion(pelicula.getCalificacion());
				resultado.get().setDuracion(pelicula.getDuracion());
				resultado.get().setNombre(pelicula.getNombre());
				resultado.get().setPrecioAlquiler(pelicula.getPrecioAlquiler());
				resultado.get().setPrecioCompra(pelicula.getPrecioCompra());
				peliculaData.save(resultado.get());
				return 1;
			}
			return 0;
		} catch (Exception e) {
			System.out.println(e);
			return -1;
		}
	}
}
