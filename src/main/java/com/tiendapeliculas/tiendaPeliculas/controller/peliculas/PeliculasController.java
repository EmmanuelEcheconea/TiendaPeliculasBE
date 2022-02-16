package com.tiendapeliculas.tiendaPeliculas.controller.peliculas;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tiendapeliculas.tiendaPeliculas.model.Pelicula;
import com.tiendapeliculas.tiendaPeliculas.service.peliculas.PeliculasService;

@RestController
@RequestMapping("/pelicula")
public class PeliculasController {

	@Autowired
	private PeliculasService peliculasService;
	
	@GetMapping("/obtener")
	public List<Pelicula> obtenerPeliculas()
	{
		return peliculasService.obtenerPeliculas();
	}
	
	@GetMapping("/obtener/{id}")
	public Pelicula obtenerPelicula(@RequestParam int id)
	{
		if(id > 0)
		{
			return peliculasService.obtenerPelicula(id);
		}
		return null;
	}
	
	@PostMapping("/insertar")
	public ResponseEntity<String> insertarPelicula(@RequestBody Pelicula pelicula)
	{
		if(pelicula != null)
		{
			byte respuesta = peliculasService.insertarPelicula(pelicula);
			if(respuesta == 1)
			{
				return new ResponseEntity<>("La pelicula se guarda de forma exitosa", HttpStatus.OK);				
			}
		}
		 return new ResponseEntity<>("La pelicula no pudo ser guarda", HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/borrar/{id}")
	public ResponseEntity<String> borrarPelicula(@RequestParam int id)
	{
		if(id > 0)
		{
			byte respuesta = peliculasService.borrarPelicula(id);
			if(respuesta == 1)
			{
				return new ResponseEntity<>("La pelicula fue borrada de forma exitosa", HttpStatus.OK);
			}
		}
		return new ResponseEntity<>("No se encontro ninguna pelicula con ese ID", HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/actualizar/{id}")
	public ResponseEntity<String> actualizarPelicula(@RequestParam int id , @RequestBody Pelicula pelicula)
	{
		if(id > 0 && pelicula != null)
		{
			byte respuesta = peliculasService.actualizarPelicula(id, pelicula);
			if(respuesta == 1)
			{
				return new ResponseEntity<>("La pelicula fue actualizada de forma exitosa", HttpStatus.OK);
			}
		}
		return new ResponseEntity<>("La pelicula no fue encontrada o no se pudo actualizar de forma correcta", HttpStatus.BAD_REQUEST);
	}
}
