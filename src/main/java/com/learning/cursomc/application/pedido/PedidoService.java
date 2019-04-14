package com.learning.cursomc.application.pedido;

import com.learning.cursomc.domain.pedido.Pedido;
import com.learning.cursomc.domain.pedido.PedidoNaoEncontrado;
import com.learning.cursomc.infrastructure.persistence.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Pedido> buscarTodas() {
        return pedidoRepository.findAll();
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
