package com.tiendapeliculas.tiendaPeliculas.service.usuarios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiendapeliculas.tiendaPeliculas.data.usuarios.IUsuariosData;
import com.tiendapeliculas.tiendaPeliculas.model.Usuario;
@Service
public class UsuariosService {

	@Autowired
	private IUsuariosData usuariosData;

	public List<Usuario> obtenerUsuarios() {
		return (List<Usuario>)usuariosData.findAll();
	}
	
	public Usuario obtenerUsuario(int id)
	{
		return usuariosData.findById(id).get();
	}
	
	public byte insertarUsuario(Usuario usuario) {
		return 0;
	}
	
	public byte actualizarUsuario(Usuario usuario) {
		return 0;
	}
	
	public byte borrarUsuario(int id) {
		return 0;
	}
}
