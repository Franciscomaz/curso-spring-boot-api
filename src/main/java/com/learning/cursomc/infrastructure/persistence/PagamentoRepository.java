package com.learning.cursomc.infrastructure.persistence;

import com.learning.cursomc.domain.pedido.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}
