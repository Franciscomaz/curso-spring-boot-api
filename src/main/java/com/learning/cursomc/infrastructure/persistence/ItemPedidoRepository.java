package com.learning.cursomc.infrastructure.persistence;

import com.learning.cursomc.domain.pedido.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
}
