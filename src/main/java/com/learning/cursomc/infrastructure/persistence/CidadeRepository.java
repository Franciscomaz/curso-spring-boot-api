package com.learning.cursomc.infrastructure.persistence;

import com.learning.cursomc.domain.endereco.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {
}
