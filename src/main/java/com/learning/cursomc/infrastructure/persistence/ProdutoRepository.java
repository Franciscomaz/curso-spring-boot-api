package com.learning.cursomc.infrastructure.persistence;

import com.learning.cursomc.domain.categoria.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
