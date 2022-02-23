package com.tiendapeliculas.tiendaPeliculas.controller.usuarios;

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
import com.tiendapeliculas.tiendaPeliculas.model.Usuario;
import com.tiendapeliculas.tiendaPeliculas.service.usuarios.UsuariosService;

@RestController
@RequestMapping("/usuario")
public class UsuariosController {

	@Autowired
	private UsuariosService usuariosService;

	@GetMapping("/obtener")
	public List<Usuario> obtenerUsuarios() {
		return usuariosService.obtenerUsuarios();
	}

	@GetMapping("/obtener/{id}")
	public Usuario obtenerUsuario(@PathVariable int id) {
		return usuariosService.obtenerUsuario(id);
	}

	@PostMapping("/insertar")
	public ResponseEntity<String> insertarUsuario(@RequestBody Usuario usuario) {
		if (usuario != null) {
			byte respuesta = usuariosService.insertarUsuario(usuario);
			if (respuesta == 1) {
				return new ResponseEntity<>("El Usuario se inserto correctamente", HttpStatus.OK);
			}
		}
		return new ResponseEntity<>("El usuario no se pudo insertar", HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/borrar/{id}")
	public ResponseEntity<String> borrarUsuario(@PathVariable int id) {
		if (id > 0) {
			byte respuesta = usuariosService.borrarUsuario(id);
			if (respuesta == 1) {
				return new ResponseEntity<>("El Usuario se borro correctamente", HttpStatus.OK);
			}
			return new ResponseEntity<>("El usuario no se encontro", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("El usuario no se pudo borar", HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/actualizar")
	public ResponseEntity<String> actualizarUsuario(@RequestBody Usuario usuario) {
		if (usuario != null) {
			//TODO cambiar el segundo parametro, cuando tenga el tema del jwt
			byte respuesta = usuariosService.actualizarUsuario(usuario,1);
			if(respuesta == 1) {
				return new ResponseEntity<>("El usuario se actualizo correctamente",HttpStatus.OK);
			}
			return new ResponseEntity<>("El usuario no se encontro",HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("El usuario no pudo ser actualizado",HttpStatus.BAD_REQUEST);
	}
}
