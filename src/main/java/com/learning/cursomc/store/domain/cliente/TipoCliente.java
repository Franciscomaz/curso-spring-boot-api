package com.learning.cursomc.store.domain.cliente;

import com.learning.cursomc.core.application.DefaultEnum;

public enum TipoCliente implements DefaultEnum {
    PESSOA_FISICA(1, "Pessoa Física"),
    PESSOA_JURIDICA(2, "Pessoa Jurídica");

    private Integer codigo;
    private String descricao;

    TipoCliente(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
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
