package com.learning.cursomc.store.application.cliente;

import com.learning.cursomc.store.domain.cliente.Cliente;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class ClienteRepresentation implements Serializable {

    private Long id;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Length(min = 5, max = 120, message = "O tamanho deve ser entro 5 e 120 caracteres")
    private String nome;

    @NotEmpty(message = "Preenchimento obrigatório")
    @Email(message = "Email inválido")
    private String email;

    public ClienteRepresentation() {
    }

    public ClienteRepresentation(Long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public static ClienteRepresentation fromEntity(Cliente cliente) {
        return new ClienteRepresentation(cliente.getId(), cliente.getNome(), cliente.getEmail());
    }

    public static Cliente toEntity(ClienteRepresentation cliente) {
        return new Cliente(cliente.getId(), cliente.getNome(), cliente.getEmail());
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

}
