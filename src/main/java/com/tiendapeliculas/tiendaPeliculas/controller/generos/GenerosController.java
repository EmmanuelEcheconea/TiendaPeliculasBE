package com.tiendapeliculas.tiendaPeliculas.controller.generos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tiendapeliculas.tiendaPeliculas.model.Genero;
import com.tiendapeliculas.tiendaPeliculas.service.generos.GenerosService;

@RestController
@RequestMapping("/genero")
public class GenerosController {

	@Autowired
	private GenerosService generosService;

	@GetMapping("/obtener")
	public List<Genero> obtenerGeneros() {
		return generosService.obtenerGeneros();
	}

	@GetMapping("/obtener/{id}")
	public Genero obtenerGenero(@PathVariable int id) {
		if (id > 0) {
			return generosService.obtenerGeneroById(id);
		}
		return null;
	}

	@PostMapping("/insertar")
	public ResponseEntity<String> insertarGenero(@RequestBody Genero genero) {
		if (genero != null) {
			byte respuesta = generosService.insertarGenero(genero);
			if (respuesta == 1) {
				return new ResponseEntity<>("El genero se inserto correctamente", HttpStatus.OK);
			}
		}
		return new ResponseEntity<>("El genero no pudo ser insertado", HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/borrar/{id}")
	public ResponseEntity<String> borrarGenero(@PathVariable int id) {
		if (id > 0) {
			byte respuesta = generosService.borrarGenero(id);
			if (respuesta == 1) {
				return new ResponseEntity<>("El genero se borro correctamente", HttpStatus.OK);
			}
			return new ResponseEntity<>("no se encontro el genero", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("El genero no se puedo borrar correctamente", HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/actualizar/{id}")
	public ResponseEntity<String> actualizarGenero(@RequestBody Genero genero, @PathVariable int id) {
		if (genero != null) {
			byte respuesta = generosService.actualizarGenero(genero, id);
			if (respuesta == 1) {
				return new ResponseEntity<>("El genero se actualizo correctamente", HttpStatus.OK);
			}
			return new ResponseEntity<>("no se encontro el genero", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("El genero no se puedo actualizar correctamente", HttpStatus.BAD_REQUEST);
	}
}
