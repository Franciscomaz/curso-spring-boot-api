package com.learning.cursomc.store.application.categoria;

import com.learning.cursomc.store.domain.categoria.Categoria;

import java.io.Serializable;

public class CategoriaDto implements Serializable {

    private Long id;
    private String nome;

    public CategoriaDto(final Categoria categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
