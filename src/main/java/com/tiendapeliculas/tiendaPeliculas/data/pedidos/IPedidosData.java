package com.tiendapeliculas.tiendaPeliculas.data.pedidos;

import org.springframework.data.repository.CrudRepository;

import com.tiendapeliculas.tiendaPeliculas.model.Pedido;

public interface IPedidosData extends CrudRepository<Pedido, Integer>{

}
