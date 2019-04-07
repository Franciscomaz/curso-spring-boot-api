package com.learning.cursomc.domain.categoria;

import com.learning.cursomc.infrastructure.exceptions.ObjectNotFound;

public class CategoriaNaoEncontrada extends ObjectNotFound {

    public CategoriaNaoEncontrada() {
        super("Categoria não encontrada.");
    }

    public CategoriaNaoEncontrada(Throwable cause) {
        super("Categoria não encontrada.", cause);
    }

    public CategoriaNaoEncontrada(String message) {
        super(message);
    }
}
