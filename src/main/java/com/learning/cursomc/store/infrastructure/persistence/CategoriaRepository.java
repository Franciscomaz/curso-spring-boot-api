package com.learning.cursomc.store.infrastructure.persistence;

import com.learning.cursomc.store.domain.categoria.Categoria;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoriaRepository extends PagingAndSortingRepository<Categoria, Long> {
}
