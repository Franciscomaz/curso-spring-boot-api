package com.learning.cursomc.store.infrastructure.persistence;

import com.learning.cursomc.store.domain.cliente.endereco.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
}
