package com.ficha.dto.request;

import jakarta.persistence.Column;

public class AtributoDtoRequest {
    private Integer idAtri;
    private String descricao;

    public AtributoDtoRequest() {
    }

    public AtributoDtoRequest(Integer idAtri, String descricao) {
        this.idAtri = idAtri;
        this.descricao = descricao;
    }

    public Integer getIdAtri() {
        return idAtri;
    }

    public void setIdAtri(Integer idAtri) {
        this.idAtri = idAtri;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
