package com.learning.cursomc.infrastructure.persistence;

import com.learning.cursomc.domain.cliente.endereco.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Estado, Long> {
}
