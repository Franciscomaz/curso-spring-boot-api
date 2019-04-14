package com.learning.cursomc.store.domain.pedido;

        import com.learning.cursomc.common.application.ObjectNotFound;

public class PedidoNaoEncontrado extends ObjectNotFound {

    public PedidoNaoEncontrado() {
        super("Pedido não encontrado.");
    }

    public PedidoNaoEncontrado(Throwable cause) {
        super("Pedido não encontrado.", cause);
    }
}
