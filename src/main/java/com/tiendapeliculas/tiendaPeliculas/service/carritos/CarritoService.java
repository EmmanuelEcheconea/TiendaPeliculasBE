package com.tiendapeliculas.tiendaPeliculas.service.carritos;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiendapeliculas.tiendaPeliculas.data.carritos.ICarritosData;
import com.tiendapeliculas.tiendaPeliculas.model.Carrito;

@Service
public class CarritoService {

	@Autowired
	private ICarritosData carritoData;

	public Carrito obtenerCarritoById(int idUser) {
		Optional<Carrito> carrito = carritoData.findById(idUser);
		if (carrito.isPresent()) {
			return carrito.get();
		}
		return null;
	}
	
	public byte insertarCarrito(Carrito carrito) {
		try {
			carritoData.save(carrito);
			return 1;
		}catch(Exception e) {
			System.out.println(e);
			return -1;
		}
	}
}
