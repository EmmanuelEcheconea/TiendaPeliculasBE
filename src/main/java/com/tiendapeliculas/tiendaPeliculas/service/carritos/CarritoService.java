package com.tiendapeliculas.tiendaPeliculas.service.carritos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiendapeliculas.tiendaPeliculas.data.carritos.ICarritosData;
import com.tiendapeliculas.tiendaPeliculas.model.Carrito;
@Service
public class CarritoService {
	
	@Autowired
	private ICarritosData carritoData;

	public Carrito obtenerCarritoById(int idUser)
	{
		return  carritoData.findById(idUser).get();
	}
}
