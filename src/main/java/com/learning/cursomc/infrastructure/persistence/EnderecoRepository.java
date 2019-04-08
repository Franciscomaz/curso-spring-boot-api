package com.learning.cursomc.infrastructure.persistence;

import com.learning.cursomc.domain.cliente.Cliente;
import com.learning.cursomc.domain.cliente.endereco.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
