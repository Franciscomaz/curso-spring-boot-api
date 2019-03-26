package com.learning.cursomc.application;

import com.learning.cursomc.domain.Categoria;
import com.learning.cursomc.infrastructure.persistence.CategoriaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria buscarPelo(Long id) {
        return categoriaRepository
                .findById(id)
                .orElse(null);
    }

    public List<Categoria> buscarTodas() {
        return categoriaRepository.findAll();
    }

    public Categoria criar(Categoria categoria) {
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
