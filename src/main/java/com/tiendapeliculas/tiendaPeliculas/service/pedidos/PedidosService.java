package com.tiendapeliculas.tiendaPeliculas.service.pedidos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiendapeliculas.tiendaPeliculas.data.pedidos.IPedidosData;
import com.tiendapeliculas.tiendaPeliculas.model.Pedido;
import com.tiendapeliculas.tiendaPeliculas.model.enums.EstadoPedidoEnum;
@Service
public class PedidosService {

	@Autowired
	private IPedidosData pedidosData;

	public List<Pedido> obtenerPedidos() {
		return (List<Pedido>) pedidosData.findAll();
	}

	public Pedido obtenerPedido(int id) {
		return pedidosData.findById(id).get();
	}

	public byte insertarPedido(Pedido pedido) {
		try {
			pedidosData.save(pedido);
			return 1;

		} catch (Exception e) {
			System.out.println(e);
			return -1;
		}
	}

	public byte actualizarEstado(int idPedido, int estado) {
		try {
			Pedido resultado = pedidosData.findById(idPedido).get();
			if (resultado != null) {
				switch (estado) {
				case 0:
					resultado.setEstado(EstadoPedidoEnum.PENDIENTE.toString());
					break;
				case 1:
					resultado.setEstado(EstadoPedidoEnum.PAGO.toString());
					break;
				case 2:
					resultado.setEstado(EstadoPedidoEnum.CANCELADO.toString());
					break;
				}
				pedidosData.save(resultado);
				return 1;
			}
			return 0;
		} catch (Exception e) {
			System.out.println(e);
			return -1;
		}
	}
}
