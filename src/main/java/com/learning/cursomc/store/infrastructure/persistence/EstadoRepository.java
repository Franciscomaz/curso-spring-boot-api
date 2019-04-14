package com.learning.cursomc.store.infrastructure.persistence;

import com.learning.cursomc.store.domain.cliente.endereco.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Estado, Long> {
}
