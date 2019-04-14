package com.learning.cursomc.store.infrastructure.persistence;

import com.learning.cursomc.store.domain.cliente.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
