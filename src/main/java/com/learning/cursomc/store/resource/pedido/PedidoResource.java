package com.learning.cursomc.store.resource.pedido;

import com.learning.cursomc.core.resource.EntityURIBuilder;
import com.learning.cursomc.store.application.pedido.PedidoService;
import com.learning.cursomc.store.domain.pedido.Pedido;
import com.learning.cursomc.store.domain.pedido.PedidoNaoEncontrado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping(value = "pedidos")
public class PedidoResource {

    private final PedidoService pedidoService;

    public PedidoResource(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Pedido> buscarPelo(@PathVariable("id") Long id) throws PedidoNaoEncontrado {
        return ResponseEntity.ok(pedidoService.buscarPelo(id));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Page<Pedido>> buscarTodas(final Pageable pageable) {
        return ResponseEntity.ok(pedidoService.buscarTodas(pageable));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Pedido> criar(@RequestBody Pedido pedido) {
        final Pedido pedidoAdicionado = pedidoService.criar(pedido);
        final URI uri = EntityURIBuilder.created(pedidoAdicionado).build();

        return ResponseEntity.created(uri).body(pedidoAdicionado);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Pedido> atualizar(@PathVariable("id") Long id, @RequestBody Pedido pedido) {
        pedido.setId(id);
        return ResponseEntity.ok(pedidoService.atualizar(pedido));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
        pedidoService.deletar(pedidoService.buscarPelo(id));
        return ResponseEntity.accepted().build();
    }

}
