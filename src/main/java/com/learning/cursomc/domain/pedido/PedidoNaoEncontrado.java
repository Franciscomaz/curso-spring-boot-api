package com.learning.cursomc.domain.pedido;

        import com.learning.cursomc.infrastructure.exceptions.ObjectNotFound;

public class PedidoNaoEncontrado extends ObjectNotFound {

    public PedidoNaoEncontrado() {
        super("Pedido não encontrado.");
    }

    public PedidoNaoEncontrado(Throwable cause) {
        super("Pedido não encontrado.", cause);
    }
}
