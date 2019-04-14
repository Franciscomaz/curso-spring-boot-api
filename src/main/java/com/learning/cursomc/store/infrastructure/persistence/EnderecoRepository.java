package com.learning.cursomc.store.infrastructure.persistence;

import com.learning.cursomc.store.domain.cliente.endereco.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
