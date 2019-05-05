package com.learning.cursomc.store.application.categoria;

import com.learning.cursomc.store.domain.categoria.Categoria;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class CategoriaRepresentation implements Serializable {

    private Long id;

    @NotEmpty(message = "O preenchimento do campo nome é obrigatório")
    @Length(min = 5, max = 80, message = "O campo nome precisa ter de 5 a 80 caracteres")
    private String nome;

    public CategoriaRepresentation() {
    }

    public CategoriaRepresentation(final Categoria categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
    }

    public static CategoriaRepresentation fromEntity(final Categoria categoria) {
        return new CategoriaRepresentation(categoria);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
