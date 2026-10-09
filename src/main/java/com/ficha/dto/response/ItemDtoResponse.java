package com.ficha.dto.response;

import java.math.BigDecimal;

public class ItemDtoResponse {
    private Integer idItem;
    private String nome;
    private BigDecimal pesoItem;

    public ItemDtoResponse() {
    }

    public ItemDtoResponse(Integer idItem, String nome, BigDecimal pesoItem) {
        this.idItem = idItem;
        this.nome = nome;
        this.pesoItem = pesoItem;
    }

    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPesoItem() {
        return pesoItem;
    }

    public void setPesoItem(BigDecimal pesoItem) {
        this.pesoItem = pesoItem;
    }
}
