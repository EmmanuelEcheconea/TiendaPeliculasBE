package com.tiendapeliculas.tiendaPeliculas.controller.carritos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public Carrito obtenerCarrito(@RequestParam int id) {
		if (id > 0) {
			return carritosService.obtenerCarritoById(id);
		}
		return null;
	}

	@GetMapping("/insertar")
	public ResponseEntity<String> insertarCarrito(@RequestBody Carrito carrito) {
		if (carrito != null) {
			byte respuesta = carritosService.insertarCarrito(carrito);
			if (respuesta == 1) {
				return new ResponseEntity<>("El carrito se inserto correctamente", HttpStatus.OK);
			}
		}
		return new ResponseEntity<>("El carrito no pudo ser insertado", HttpStatus.BAD_REQUEST);
	}
}
