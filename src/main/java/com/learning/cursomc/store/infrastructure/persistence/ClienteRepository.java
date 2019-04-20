package com.learning.cursomc.store.infrastructure.persistence;

import com.learning.cursomc.store.domain.cliente.Cliente;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Long> {
}
