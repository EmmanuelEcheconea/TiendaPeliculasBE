package com.tiendapeliculas.tiendaPeliculas.controller.productos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiendapeliculas.tiendaPeliculas.service.productos.ProductosService;

@RestController
@RequestMapping("/producto")
public class ProductosController {

	@Autowired
	private ProductosService productosService;
	
	@PostMapping("/insertar")
	public ResponseEntity<String> insertarProducto(@RequestBody int idPelicula)
	{
		if(idPelicula > 0)
		{
			byte respuesta = productosService.insertarProducto(idPelicula);
			if(respuesta == 1)
			{
				return new ResponseEntity<>("El producto se guardo de forma exitosa", HttpStatus.OK);				
			}else if(respuesta == 0)
			{
				return new ResponseEntity<>("El id no existe", HttpStatus.BAD_REQUEST);				
			}
		}
		return new ResponseEntity<>("Hubo un problema al intentar guardar el producto", HttpStatus.BAD_REQUEST);							
	}
	
	@PostMapping("/eliminar")
	public ResponseEntity<String> borrarProducto(@RequestBody int idPelicula)
	{
		if(idPelicula > 0)
		{
			byte respuesta = productosService.borrarProducto(idPelicula);
			if(respuesta == 1)
			{
				return new ResponseEntity<>("El producto se borro de forma exitosa", HttpStatus.OK);				
			}else if(respuesta == 0)
			{
				return new ResponseEntity<>("El id no existe", HttpStatus.BAD_REQUEST);				
			}
		}
		return new ResponseEntity<>("Hubo un problema al intentar borrar el producto", HttpStatus.BAD_REQUEST);
	}
}
