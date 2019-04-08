package com.learning.cursomc.domain.cliente;

public enum TipoCliente {
    PESSOA_FISICA(1, "Pessoa Física"),
    PESSOA_JURIDICA(2, "Pessoa Jurídica");

    private int codigo;
    private String nome;

    TipoCliente(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public static TipoCliente toEnum(Integer codigo) {
        if (codigo == null) {
            return null;
        }

        for (TipoCliente tipoCliente : TipoCliente.values()) {
            if (codigo.equals(tipoCliente.codigo)) {
                return tipoCliente;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + codigo);
    }

}
