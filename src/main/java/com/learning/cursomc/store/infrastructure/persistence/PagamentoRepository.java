package com.learning.cursomc.store.infrastructure.persistence;

import com.learning.cursomc.store.domain.pedido.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}
