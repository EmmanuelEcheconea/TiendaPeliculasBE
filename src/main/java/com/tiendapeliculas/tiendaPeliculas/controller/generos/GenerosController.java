package com.tiendapeliculas.tiendaPeliculas.controller.generos;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.tiendapeliculas.tiendaPeliculas.model.Genero;

@RestController
@RequestMapping("/Genero")
public class GenerosController {

	@GetMapping("/obtener")
	public List<Genero> obtenerGeneros()
	{
		return null;
	}
	
	@GetMapping("/obtener/{id}")
	public Genero obtenerGenero(@RequestParam int id)
	{
		return null;
	}
	
	@PostMapping("/insertar")
	public ResponseEntity<String> insertarGenero(@RequestBody Genero genero)
	{
		return null;
	}
	
	@PostMapping("/borrar/{id}")
	public ResponseEntity<String> borrarGenero(@RequestParam int id)
	{
		return null;
	}
	
	@PostMapping("/actualizar")
	public ResponseEntity<String> actualizarGenero(@RequestBody Genero genero)
	{
		return null;
	}
}
