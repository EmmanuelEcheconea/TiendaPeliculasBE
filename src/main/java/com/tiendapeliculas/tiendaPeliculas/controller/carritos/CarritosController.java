package com.tiendapeliculas.tiendaPeliculas.controller.carritos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.tiendapeliculas.tiendaPeliculas.model.Carrito;
import com.tiendapeliculas.tiendaPeliculas.service.carritos.CarritoService;

@RestController
@RequestMapping("/carrito")
public class CarritosController {
	
	@Autowired
	private CarritoService carritosService;
	
	@GetMapping("/obtener/{id}")
	public Carrito obtenerCarrito(@RequestParam int id)
	{
		if(id > 0)
		{
			return carritosService.obtenerCarritoById(id);
		}
		return null;
	}	
}
