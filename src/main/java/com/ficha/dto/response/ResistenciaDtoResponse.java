package com.ficha.dto.response;

public class ResistenciaDtoResponse {

    private Integer idRes;
    private String descricao;

    public ResistenciaDtoResponse() {
    }

    public ResistenciaDtoResponse(Integer idRes, String descricao) {
        this.idRes = idRes;
        this.descricao = descricao;
    }

    public Integer getIdRes() {
        return idRes;
    }

    public void setIdRes(Integer idRes) {
        this.idRes = idRes;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
