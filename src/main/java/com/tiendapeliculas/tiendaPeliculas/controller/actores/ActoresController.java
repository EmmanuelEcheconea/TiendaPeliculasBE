package com.tiendapeliculas.tiendaPeliculas.controller.actores;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.tiendapeliculas.tiendaPeliculas.model.Actor;

@RestController
@RequestMapping("/Actor")
public class ActoresController {

	@GetMapping("/obtener")
	public List<Actor> obtenerActores()
	{
		return null;
	}
	
	@GetMapping("/obtener/{id}")
	public Actor obtenerActor(@RequestParam int id)
	{
		return null;
	}
	
	@PostMapping("/insertar")
	public ResponseEntity<String> insertarActor(@RequestBody Actor actor)
	{
		return null;
	}
	
	@PostMapping("/borrar/{id}")
	public ResponseEntity<String> borrarActor(@RequestParam int id)
	{
		return null;
	}
	
	@PostMapping("/actualizar")
	public ResponseEntity<String> actualizarActor(@RequestBody Actor actor)
	{
		return null;
	}
}
