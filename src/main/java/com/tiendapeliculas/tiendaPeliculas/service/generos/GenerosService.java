package com.tiendapeliculas.tiendaPeliculas.service.generos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiendapeliculas.tiendaPeliculas.data.generos.IGenerosData;
import com.tiendapeliculas.tiendaPeliculas.model.Genero;

@Service
public class GenerosService {

	@Autowired
	private IGenerosData generoData;

	public List<Genero> obtenerGeneros() {
		return (List<Genero>) generoData.findAll();
	}

	public Genero obtenerGeneroById(int id) {
		Optional<Genero> genero = generoData.findById((long)id);
		if (genero.isPresent()) {
			return genero.get();
		}
		return null;
	}

	public byte insertarGenero(Genero genero) {
		try {
			generoData.save(genero);
			return 1;
		} catch (Exception e) {
			System.out.println(e);
			return -1;
		}
	}

	public byte borrarGenero(int id) {
		try {
			Optional<Genero> genero = generoData.findById((long)id);
			if (genero.isPresent()) {
				generoData.delete(genero.get());
				return 1;
			}
			return 0;
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}
	}
	
	public byte actualizarGenero(Genero genero, int id) {
		try {
			Optional<Genero> resultado = generoData.findById((long)id);
			if(resultado.isPresent()) {
				resultado.get().setNombre(genero.getNombre());
				generoData.save(resultado.get());
				return 1;
			}
			return 0;
		}catch(Exception e) {
			System.out.println(e);
			return -1;
		}
	}
}
