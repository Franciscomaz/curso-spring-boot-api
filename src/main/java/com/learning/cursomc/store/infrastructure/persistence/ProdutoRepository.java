package com.learning.cursomc.store.infrastructure.persistence;

import com.learning.cursomc.store.domain.categoria.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
