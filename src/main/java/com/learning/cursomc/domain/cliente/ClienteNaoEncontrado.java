package com.learning.cursomc.domain.cliente;

import com.learning.cursomc.infrastructure.exceptions.ObjectNotFound;

public class ClienteNaoEncontrado extends ObjectNotFound {

    public ClienteNaoEncontrado() {
        super("Cliente não encontrado.");
    }

    public ClienteNaoEncontrado(Throwable cause) {
        super("Cliente não encontrado.", cause);
    }
}
