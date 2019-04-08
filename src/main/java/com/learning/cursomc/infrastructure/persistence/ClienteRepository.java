package com.learning.cursomc.infrastructure.persistence;

import com.learning.cursomc.domain.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
