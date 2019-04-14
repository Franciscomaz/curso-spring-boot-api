package com.learning.cursomc.store.infrastructure.persistence;

import com.learning.cursomc.store.domain.pedido.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
}
