package com.learning.cursomc.store.application.categoria;

import com.learning.cursomc.store.domain.categoria.Categoria;
import com.learning.cursomc.store.domain.categoria.CategoriaNaoEncontrada;
import com.learning.cursomc.store.infrastructure.persistence.CategoriaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria buscarPelo(Long id) throws CategoriaNaoEncontrada {
        return categoriaRepository
                .findById(id)
                .orElseThrow(CategoriaNaoEncontrada::new);
    }

    public Page<Categoria> buscarTodas(final Pageable pageable) {
        return categoriaRepository.findAll(pageable);
    }

    public Categoria criar(Categoria categoria) {
        categoria.setId(null);
        return categoriaRepository.save(categoria);
    }

    public Categoria atualizar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria deletar(Categoria categoria) {
        categoriaRepository.delete(categoria);
        return categoria;
    }
}
