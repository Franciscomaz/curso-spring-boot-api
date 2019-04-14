package com.learning.cursomc.infrastructure.persistence;

import com.learning.cursomc.domain.pedido.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
