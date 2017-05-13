package com.SpringBootAndMaterialize.SpringBootAndMaterialize.model;

/**
 * Created by lucasbarros on 13/05/17.
 */

public enum Tipo {

    ENTRADA("Entrada"),
    SAIDA("Saída");

    private String descricao;

    Tipo(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
