package com.tiendapeliculas.tiendaPeliculas.controller.pedidos;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tiendapeliculas.tiendaPeliculas.model.Pedido;

@RestController
@RequestMapping("/pedido")
public class PedidosController {
	
	@GetMapping("/obtener")
	public List<Pedido> obtenerPedidos()
	{
		return null;
	}
	
	@GetMapping("/obtener/{id}")
	public Pedido obtenerPedido(@RequestParam int id)
	{
		return null;
	}
	
	@PostMapping("/insertar")
	public ResponseEntity<String> insertarPedido(@RequestBody Pedido pedido)
	{
		
		return null;
	}
	
	@PutMapping("/actualizarEstado/{id}")
	public ResponseEntity<String> actualizarEstado(@RequestParam int id)
	{
		return null;
	}
}
