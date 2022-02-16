package com.tiendapeliculas.tiendaPeliculas.service.peliculas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiendapeliculas.tiendaPeliculas.data.peliculas.IPeliculasData;
import com.tiendapeliculas.tiendaPeliculas.model.Pelicula;

@Service
public class PeliculasService {
	
	
	@Autowired
	private IPeliculasData peliculaData;
	
	public List<Pelicula> obtenerPeliculas()
	{
		return (List<Pelicula>) peliculaData.findAll();
	}
	
	public Pelicula obtenerPelicula(int id)
	{
		return peliculaData.findById(id).get();
	}
	
	public byte insertarPelicula(Pelicula pelicula)
	{
		try {
			peliculaData.save(pelicula);
			return 1;
		}
		catch(Exception e) {
			System.out.println(e);
			return 0;
		}
	}
	
	public byte borrarPelicula(int id)
	{
		try {
			Pelicula pelicula = obtenerPelicula(id);
			peliculaData.delete(pelicula);
			return 1;
		}
		catch(Exception e) {
			System.out.println(e);
			return 0;
		}
	}
	
	public byte actualizarPelicula(int id, Pelicula pelicula)
	{
		try 
		{
			Pelicula peliculaObtenida = obtenerPelicula(id);
			peliculaObtenida.setCalificacion(pelicula.getCalificacion());
			peliculaObtenida.setDuracion(pelicula.getDuracion());
			peliculaObtenida.setElenco(pelicula.getElenco());
			peliculaObtenida.setGeneros(pelicula.getGeneros());
			peliculaObtenida.setNombre(pelicula.getNombre());
			peliculaObtenida.setPrecioAlquiler(pelicula.getPrecioAlquiler());
			peliculaObtenida.setPrecioCompra(pelicula.getPrecioCompra());
			peliculaData.save(peliculaObtenida);
			return 1;
		}catch (Exception e)
		{
			System.out.println(e);
			return 0;
		}
	}
}
