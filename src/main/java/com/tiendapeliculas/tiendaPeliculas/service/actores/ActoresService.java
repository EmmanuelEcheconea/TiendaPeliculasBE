package com.tiendapeliculas.tiendaPeliculas.service.actores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tiendapeliculas.tiendaPeliculas.data.actores.IActoresData;
import com.tiendapeliculas.tiendaPeliculas.model.Actor;

@Service
public class ActoresService {

	@Autowired
	private IActoresData actoresData;

	public List<Actor> obtenerActores() {
		return (List<Actor>) actoresData.findAll();
	}

	public Actor obtenerActor(int id) {
		try {
			Optional<Actor> actor = actoresData.findById((long) id);
			if (actor.isPresent()) {
				return actor.get();
			}
			return null;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public byte insertarActor(Actor actor) {
		try {
			actoresData.save(actor);
			return 1;
		} catch (Exception e) {
			System.out.println(e);
			return -1;
		}
	}

	public byte borrarActor(int id) {
		try {
			Optional<Actor> resultado = actoresData.findById((long) id);
			if (resultado.isPresent() && resultado != null) {
				actoresData.delete(resultado.get());
				return 1;
			}
			return 0;
		} catch (Exception e) {
			System.out.println(e);
			return -1;
		}
	}

	public byte actualizarActor(Actor actor, int id) {
		try {
			Optional<Actor> resultado = actoresData.findById((long) id);
			if (resultado.isPresent() && resultado != null) {
				resultado.get().setNombre(actor.getNombre());
				resultado.get().setApellido(actor.getApellido());
				resultado.get().setEdad(actor.getEdad());
				resultado.get().setNacionalidad(actor.getNacionalidad());
				resultado.get().setFechaDeNacimiento(actor.getFechaDeNacimiento());
				resultado.get().setFechaDeMuerte(actor.getFechaDeMuerte());
				actoresData.save(resultado.get());
				return 1;
			}
			return 0;
		} catch (Exception e) {
			System.out.println(e);
			return -1;
		}
	}
}