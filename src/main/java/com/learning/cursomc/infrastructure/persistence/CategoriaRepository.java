package com.learning.cursomc.infrastructure.persistence;

import com.learning.cursomc.domain.categoria.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
