package com.ficha.dto.response;

public class ProficienciaDtoResponse {

    private Integer idProe;
    private String descricao;

    public ProficienciaDtoResponse() {
    }

    public ProficienciaDtoResponse(Integer idProe, String descricao) {
        this.idProe = idProe;
        this.descricao = descricao;
    }

    public Integer getIdProe() {
        return idProe;
    }

    public void setIdProe(Integer idProe) {
        this.idProe = idProe;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
