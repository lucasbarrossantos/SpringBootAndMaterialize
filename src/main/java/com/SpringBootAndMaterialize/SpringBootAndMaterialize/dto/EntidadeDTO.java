package com.SpringBootAndMaterialize.SpringBootAndMaterialize.dto;


public class EntidadeDTO {

    private Long codigo;
    private String nome;

    public EntidadeDTO(Long codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
