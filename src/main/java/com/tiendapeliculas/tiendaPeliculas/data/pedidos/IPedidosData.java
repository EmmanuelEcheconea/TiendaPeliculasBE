package com.tiendapeliculas.tiendaPeliculas.data.pedidos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tiendapeliculas.tiendaPeliculas.model.Pedido;
@Repository
public interface IPedidosData extends CrudRepository<Pedido, Integer>{

}
