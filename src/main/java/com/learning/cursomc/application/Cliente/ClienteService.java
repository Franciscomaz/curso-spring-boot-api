package com.learning.cursomc.application.Cliente;

import com.learning.cursomc.domain.cliente.Cliente;
import com.learning.cursomc.domain.cliente.ClienteNaoEncontrado;
import com.learning.cursomc.infrastructure.persistence.ClienteRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente buscarPelo(Long id) throws ClienteNaoEncontrado {
        return clienteRepository
                .findById(id)
                .orElseThrow(ClienteNaoEncontrado::new);
    }

    public List<Cliente> buscarTodas() {
        return clienteRepository.findAll();
    }

    public Cliente criar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente atualizar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente deletar(Cliente cliente) {
        clienteRepository.delete(cliente);
        return cliente;
    }
    
}
