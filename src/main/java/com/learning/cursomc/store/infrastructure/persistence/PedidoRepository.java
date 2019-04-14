package com.learning.cursomc.store.infrastructure.persistence;

import com.learning.cursomc.store.domain.pedido.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
