package com.learning.cursomc.resources.cliente;

import com.learning.cursomc.application.cliente.ClienteService;
import com.learning.cursomc.domain.cliente.Cliente;
import com.learning.cursomc.domain.cliente.ClienteNaoEncontrado;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "clientes/")
public class ClienteResource {
    
    private final ClienteService clienteService;

    public ClienteResource(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Cliente buscarPelo(@PathVariable("id") Long id) throws ClienteNaoEncontrado {
        return clienteService.buscarPelo(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Cliente> buscarTodas() {
        return clienteService.buscarTodas();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Cliente criar(@RequestBody Cliente cliente) {
        return clienteService.criar(cliente);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Cliente atualizar(@RequestBody Cliente cliente) {
        return clienteService.atualizar(cliente);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public Cliente deletar(@PathVariable("id") Long id) {
        return null;
    }
    
}
