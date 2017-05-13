package com.SpringBootAndMaterialize.SpringBootAndMaterialize.model;

/**
 * Created by lucasbarros on 13/05/17.
 */
public enum Situacao {

    COMPENSADO("Compensado"),
    PAGAMENTONAOREALIZADO("Pagamento não realizado"),
    CANCELADO("Cancelado");

    private String descricao;

    Situacao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
