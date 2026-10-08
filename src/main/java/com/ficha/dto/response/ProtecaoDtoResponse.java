package com.ficha.dto.response;

public class ProtecaoDtoResponse {
    private Integer idProtecao;

    private String descricao;

    public ProtecaoDtoResponse(Integer idProtecao, String descricao) {
        this.idProtecao = idProtecao;
        this.descricao = descricao;
    }

    public ProtecaoDtoResponse() {
    }

    public Integer getIdProtecao() {
        return idProtecao;
    }

    public void setIdProtecao(Integer idProtecao) {
        this.idProtecao = idProtecao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
