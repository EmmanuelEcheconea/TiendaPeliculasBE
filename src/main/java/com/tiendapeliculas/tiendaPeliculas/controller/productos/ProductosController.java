package com.tiendapeliculas.tiendaPeliculas.controller.productos;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producto")
public class ProductosController {

	@PostMapping("/insertar")
	public ResponseEntity<String> insertarProducto(@RequestBody int idPelicula)
	{
		return null;
	}
}
