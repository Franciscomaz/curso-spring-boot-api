package com.learning.cursomc.store.domain.cliente;

import com.learning.cursomc.common.application.ObjectNotFound;

public class ClienteNaoEncontrado extends ObjectNotFound {

    public ClienteNaoEncontrado() {
        super("Cliente não encontrado.");
    }

    public ClienteNaoEncontrado(Throwable cause) {
        super("Cliente não encontrado.", cause);
    }
}
