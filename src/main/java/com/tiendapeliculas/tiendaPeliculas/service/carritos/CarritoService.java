package com.tiendapeliculas.tiendaPeliculas.service.carritos;

import org.springframework.beans.factory.annotation.Autowired;
import com.tiendapeliculas.tiendaPeliculas.data.carritos.ICarritosData;
import com.tiendapeliculas.tiendaPeliculas.model.Carrito;

public class CarritoService {
	
	@Autowired
	private ICarritosData carritoData;

	public Carrito obtenerCarritoById(int idUser)
	{
		return  carritoData.findById(idUser).get();
	}
}
