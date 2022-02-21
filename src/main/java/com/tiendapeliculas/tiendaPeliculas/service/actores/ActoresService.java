package com.tiendapeliculas.tiendaPeliculas.service.actores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tiendapeliculas.tiendaPeliculas.data.actores.IActoresData;
import com.tiendapeliculas.tiendaPeliculas.model.Actor;

public class ActoresService {

	@Autowired
	private IActoresData actoresData;

	public List<Actor> obtenerActores() {
		return (List<Actor>) actoresData.findAll();
	}

	public Actor obtenerActor(int id) {
		try {
			return actoresData.findById(id).get();
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
			Actor resultado = actoresData.findById(id).get();
			if (resultado != null) {
				actoresData.delete(resultado);
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
			Actor resultado = actoresData.findById(id).get();
			if(resultado != null)
			{
				actoresData.save(resultado);
				return 1;
			}
			return 0;
		}catch(Exception e) {
			System.out.println(e);
			return -1;
		}
	}
}
