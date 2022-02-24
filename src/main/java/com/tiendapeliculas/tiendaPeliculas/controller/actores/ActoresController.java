package com.tiendapeliculas.tiendaPeliculas.controller.actores;

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
import com.tiendapeliculas.tiendaPeliculas.model.Actor;
import com.tiendapeliculas.tiendaPeliculas.service.actores.ActoresService;

@RestController
@RequestMapping("/actor")
public class ActoresController {

	@Autowired
	private ActoresService actoresService;

	@GetMapping("/obtener")
	public List<Actor> obtenerActores() {
		return actoresService.obtenerActores();
	}

	@GetMapping("/obtener/{id}")
	public Actor obtenerActor(@PathVariable int id) {
		if (id > 0) {
			return actoresService.obtenerActor(id);
		}
		return null;
	}

	@PostMapping("/insertar")
	public ResponseEntity<String> insertarActor(@RequestBody Actor actor) {
		if (actor != null) {
			byte resultado = actoresService.insertarActor(actor);
			if (resultado == 1) {
				return new ResponseEntity<>("El Actor se inserto correctamente", HttpStatus.OK);
			}
		}
		return new ResponseEntity<>("El Actor no se pudo insertar", HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/borrar/{id}")
	public ResponseEntity<String> borrarActor(@PathVariable int id) {
		if (id > 0) {
			byte resultado = actoresService.borrarActor(id);
			if (resultado == 1) {
				return new ResponseEntity<>("El Actor se elimino correctamente", HttpStatus.OK);
			}
			return new ResponseEntity<>("El Actor no se encontro en la Base de datos", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("El Actor no se pudo elminar", HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/actualizar/{id}")
	public ResponseEntity<String> actualizarActor(@RequestBody Actor actor, @PathVariable int id) {
		if (id > 0) {
			byte resultado = actoresService.actualizarActor(actor, id);
			if (resultado == 1) {
				return new ResponseEntity<>("El Actor se actualizo correctamente", HttpStatus.OK);
			}
			return new ResponseEntity<>("El Actor no se encontro en la Base de datos", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("El Actor no se pudo actualizar", HttpStatus.BAD_REQUEST);
	}
}
