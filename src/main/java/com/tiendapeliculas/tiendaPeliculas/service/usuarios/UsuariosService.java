package com.tiendapeliculas.tiendaPeliculas.service.usuarios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiendapeliculas.tiendaPeliculas.data.usuarios.IUsuariosData;
import com.tiendapeliculas.tiendaPeliculas.model.Usuario;

@Service
public class UsuariosService {

	@Autowired
	private IUsuariosData usuariosData;

	public List<Usuario> obtenerUsuarios() {
		return (List<Usuario>) usuariosData.findAll();
	}

	public Usuario obtenerUsuario(int id) {
		try {

			Optional<Usuario> usuario = usuariosData.findById(id);
			if (usuario.isPresent()) {
				return usuario.get();
			}
			return null;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public byte insertarUsuario(Usuario usuario) {
		try {
			usuariosData.save(usuario);
			return 1;
		} catch (Exception e) {
			System.out.println(e);
			return -1;
		}
	}

	public byte actualizarUsuario(Usuario usuario, int id) {
		try {
			Optional<Usuario> resultado = usuariosData.findById(id);
			if (resultado.isPresent()) {
				resultado.get().setNombre(usuario.getNombre());
				resultado.get().setApellido(usuario.getApellido());
				resultado.get().setEmail(usuario.getEmail());
				resultado.get().setUsuario(usuario.getUsuario());
				resultado.get().setContrasena(usuario.getContrasena());
				resultado.get().setId_rol(usuario.getId_rol());
				usuariosData.save(resultado.get());
				return 1;
			}
			return 0;
		} catch (Exception e) {
			System.out.println(e);
			return -1;
		}
	}

	public byte borrarUsuario(int id) {
		try {
			Optional<Usuario> respuesta = usuariosData.findById(id);
			if (respuesta.isPresent()) {
				usuariosData.delete(respuesta.get());
				return 1;
			}
			return 0;
		} catch (Exception e) {
			System.out.println(e);
			return -1;
		}
	}
}
