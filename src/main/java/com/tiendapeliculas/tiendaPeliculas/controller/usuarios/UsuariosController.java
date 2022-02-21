package com.tiendapeliculas.tiendaPeliculas.controller.usuarios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tiendapeliculas.tiendaPeliculas.model.Usuario;
import com.tiendapeliculas.tiendaPeliculas.service.usuarios.UsuariosService;

@RestController
@RequestMapping("/usuario")
public class UsuariosController {

	@Autowired
	private UsuariosService usuariosService;
	
	@GetMapping("/obtener")
	public List<Usuario> obtenerUsuarios()
	{
		return usuariosService.obtenerUsuarios();
	}
	
	@GetMapping("/obtener/{id}")
	public Usuario obtenerUsuario(@RequestParam int id)
	{
		return usuariosService.obtenerUsuario(id);
	}
	
	@PostMapping("/insertar")
	public ResponseEntity<String> insertarUsuario(@RequestBody Usuario usuario)
	{
		return null;
	}
	
	@PostMapping("/borrar/{id}")
	public ResponseEntity<String> borrarUsuario(@RequestParam int id)
	{
		return null;
	}
	
	@PostMapping("/actualizar")
	public ResponseEntity<String> actualizarUsuario(@RequestBody Usuario usuario)
	{
		return null;
	}
}
