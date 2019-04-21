package com.learning.cursomc.store.application.pedido;

import com.learning.cursomc.store.domain.pedido.Pedido;
import com.learning.cursomc.store.domain.pedido.PedidoNaoEncontrado;
import com.learning.cursomc.store.infrastructure.persistence.PedidoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public Pedido buscarPelo(Long id) throws PedidoNaoEncontrado {
        return pedidoRepository
                .findById(id)
                .orElseThrow(PedidoNaoEncontrado::new);
    }

    public Page<Pedido> buscarTodas(final Pageable pageable) {
        return pedidoRepository.findAll(pageable);
    }

    public Pedido criar(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Pedido atualizar(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Pedido deletar(Pedido pedido) {
        pedidoRepository.delete(pedido);
        return pedido;
    }

}
