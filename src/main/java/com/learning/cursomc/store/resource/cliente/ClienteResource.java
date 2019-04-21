package com.learning.cursomc.store.resource.cliente;

import com.learning.cursomc.core.resource.EntityURIBuilder;
import com.learning.cursomc.store.application.cliente.ClienteService;
import com.learning.cursomc.store.domain.cliente.Cliente;
import com.learning.cursomc.store.domain.cliente.ClienteNaoEncontrado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping(value = "clientes")
public class ClienteResource {

    private final ClienteService clienteService;

    public ClienteResource(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Cliente> buscarPelo(@PathVariable("id") Long id) throws ClienteNaoEncontrado {
        return ResponseEntity.ok(clienteService.buscarPelo(id));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Page<Cliente>> buscarTodas(final Pageable pageable) {
        return ResponseEntity.ok(clienteService.buscarTodas(pageable));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Cliente> criar(@RequestBody Cliente cliente) {
        final Cliente clienteAdicionado = clienteService.criar(cliente);
        final URI uri = EntityURIBuilder.created(clienteAdicionado).build();

        return ResponseEntity.created(uri).body(clienteAdicionado);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Cliente> atualizar(@PathVariable("id") Long id, @RequestBody Cliente cliente) {
        cliente.setId(id);
        return ResponseEntity.ok(clienteService.atualizar(cliente));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
        clienteService.deletar(clienteService.buscarPelo(id));
        return ResponseEntity.accepted().build();
    }

}
