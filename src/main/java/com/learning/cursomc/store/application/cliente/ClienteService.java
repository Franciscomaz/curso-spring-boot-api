package com.learning.cursomc.store.application.cliente;

import com.learning.cursomc.core.application.exception.DataIntegrityException;
import com.learning.cursomc.store.domain.cliente.Cliente;
import com.learning.cursomc.store.domain.cliente.ClienteNaoEncontrado;
import com.learning.cursomc.store.infrastructure.persistence.ClienteRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

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

    public Page<Cliente> buscarTodas(final Pageable pageable) {
        return clienteRepository.findAll(pageable);
    }

    public Cliente criar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente atualizar(Long id, Cliente clienteComNovosDados) {
        Cliente clienteASerAtualizado = buscarPelo(id);
        clienteASerAtualizado.setNome(clienteComNovosDados.getNome());
        clienteASerAtualizado.setEmail(clienteComNovosDados.getEmail());
        return clienteRepository.save(clienteASerAtualizado);
    }

    public Cliente deletar(Cliente cliente) {
        try {
            clienteRepository.delete(cliente);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("O cliente " + cliente.getNome() + " possui registros dependentes");
        }

        return cliente;
    }

}
