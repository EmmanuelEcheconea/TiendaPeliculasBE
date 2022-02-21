package com.tiendapeliculas.tiendaPeliculas.controller.pedidos;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.tiendapeliculas.tiendaPeliculas.model.Pedido;
import com.tiendapeliculas.tiendaPeliculas.service.pedidos.PedidosService;

@RestController
@RequestMapping("/pedido")
public class PedidosController {

	@Autowired
	private PedidosService pedidosService;

	@GetMapping("/obtener")
	public List<Pedido> obtenerPedidos() {
		return pedidosService.obtenerPedidos();
	}

	@GetMapping("/obtener/{id}")
	public Pedido obtenerPedido(@RequestParam int id) {
		return pedidosService.obtenerPedido(id);
	}

	@PostMapping("/insertar")
	public ResponseEntity<String> insertarPedido(@RequestBody Pedido pedido) {
		if (pedido != null) {
			byte respuesta = pedidosService.insertarPedido(pedido);
			if (respuesta == 1) {
				return new ResponseEntity<>("El pedido fue insertada de forma exitosa", HttpStatus.OK);
			}
		}
		return new ResponseEntity<>("El pedido no pudo insertarse correctamente", HttpStatus.BAD_REQUEST);

	}

	@PutMapping("/actualizarEstado/{id}")
	public ResponseEntity<String> actualizarEstado(@RequestParam int id, @RequestBody int estado) {
		if (id > 0 && (estado >= -1 && estado <= 1)) {
			byte respuesta = pedidosService.actualizarEstado(id, estado);
			if (respuesta == 1) {
				return new ResponseEntity<>("El estado del pedido fue actualizado correctamente", HttpStatus.OK);
			}
			return new ResponseEntity<>("El estado del pedido no se pudo actualizar, el id del pedido no se encontro",
					HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("El pepido no se pudo actualizar, los parametros estan incorrectos",
				HttpStatus.BAD_REQUEST);
	}
}
