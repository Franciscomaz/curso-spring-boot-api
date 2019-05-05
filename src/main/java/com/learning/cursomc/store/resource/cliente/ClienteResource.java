package com.learning.cursomc.store.resource.cliente;

import com.learning.cursomc.core.resource.EntityURIBuilder;
import com.learning.cursomc.store.application.cliente.ClienteRepresentation;
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
    public ResponseEntity<ClienteRepresentation> buscarPelo(@PathVariable("id") Long id) throws ClienteNaoEncontrado {
        return ResponseEntity.ok(ClienteRepresentation.fromEntity(clienteService.buscarPelo(id)));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Page<ClienteRepresentation>> buscarTodas(final Pageable pageable) {
        return ResponseEntity.ok(clienteService.buscarTodas(pageable).map(ClienteRepresentation::fromEntity));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ClienteRepresentation> criar(@RequestBody ClienteRepresentation cliente) {
        final Cliente clienteAdicionado = clienteService.criar(ClienteRepresentation.toEntity(cliente));
        final URI uri = EntityURIBuilder.created(clienteAdicionado).build();

        return ResponseEntity.created(uri).body(ClienteRepresentation.fromEntity(clienteAdicionado));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<ClienteRepresentation> atualizar(@PathVariable("id") Long id, @RequestBody ClienteRepresentation aRepresentation) {
        return ResponseEntity.ok(ClienteRepresentation.fromEntity(clienteService.atualizar(id, ClienteRepresentation.toEntity(aRepresentation))));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
        clienteService.deletar(clienteService.buscarPelo(id));
        return ResponseEntity.accepted().build();
    }

}
