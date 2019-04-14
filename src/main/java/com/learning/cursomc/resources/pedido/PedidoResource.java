package com.learning.cursomc.resources.pedido;

import com.learning.cursomc.application.pedido.PedidoService;
import com.learning.cursomc.domain.pedido.Pedido;
import com.learning.cursomc.domain.pedido.PedidoNaoEncontrado;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "pedidos/")
public class PedidoResource {
    
    private final PedidoService pedidoService;

    public PedidoResource(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Pedido buscarPelo(@PathVariable("id") Long id) throws PedidoNaoEncontrado {
        return pedidoService.buscarPelo(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Pedido> buscarTodas() {
        return pedidoService.buscarTodas();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Pedido criar(@RequestBody Pedido pedido) {
        return pedidoService.criar(pedido);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Pedido atualizar(@RequestBody Pedido pedido) {
        return pedidoService.atualizar(pedido);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public Pedido deletar(@PathVariable("id") Long id) {
        return null;
    }
    
}
