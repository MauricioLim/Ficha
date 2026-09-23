package com.ficha.dto.response;

import jakarta.persistence.Column;

public class AtributoDtoResponse {

    private Integer idAtri;

    private String descricao;

    public AtributoDtoResponse() {
    }

    public AtributoDtoResponse(Integer idAtri, String descricao) {
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
