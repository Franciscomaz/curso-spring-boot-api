package com.learning.cursomc.store.infrastructure.persistence;

import com.learning.cursomc.store.domain.categoria.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
