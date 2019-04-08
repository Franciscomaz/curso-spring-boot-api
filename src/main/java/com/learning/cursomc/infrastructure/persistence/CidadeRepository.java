package com.learning.cursomc.infrastructure.persistence;

import com.learning.cursomc.domain.cliente.endereco.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
}
