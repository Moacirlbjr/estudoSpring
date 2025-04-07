package com.moacirbarbosa.estudo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moacirbarbosa.estudo.domain.ItemPedido;
import com.moacirbarbosa.estudo.domain.ItemPedidoPK;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, ItemPedidoPK> {
	
}
