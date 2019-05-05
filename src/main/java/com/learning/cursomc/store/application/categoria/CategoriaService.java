package com.learning.cursomc.store.application.categoria;

import com.learning.cursomc.core.application.exception.DataIntegrityException;
import com.learning.cursomc.store.domain.categoria.Categoria;
import com.learning.cursomc.store.domain.categoria.CategoriaNaoEncontrada;
import com.learning.cursomc.store.infrastructure.persistence.CategoriaRepository;
import org.springframework.dao.DataIntegrityViolationException;
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

    public Categoria atualizar(Long id, Categoria categoriaComNovoNome) {
        final Categoria categoriaASerAtualizada = buscarPelo(id);
        categoriaASerAtualizada.setNome(categoriaComNovoNome.getNome());
        return categoriaRepository.save(categoriaASerAtualizada);
    }

    public Categoria deletar(Categoria categoria) {
        try {
            categoriaRepository.deleteById(categoria.getId());
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("A categoria " + categoria.getNome() + " possui registros dependentes");
        }

        return categoria;
    }
}
