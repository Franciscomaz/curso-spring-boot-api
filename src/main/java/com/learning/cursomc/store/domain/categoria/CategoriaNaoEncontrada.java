package com.learning.cursomc.store.domain.categoria;

import com.learning.cursomc.core.application.exception.ObjectNotFound;

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
