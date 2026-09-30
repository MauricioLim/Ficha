package com.ficha.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AtributoDtoRequest {

    @NotBlank(message = "A descrição é obrigatório")
    @Size(max = 50, message = "A descrição pode ter no máximo 50 caracteres")
    private String descricao;

    public AtributoDtoRequest() {
    }

    public AtributoDtoRequest(String descricao) {
        this.descricao = descricao;
    }


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
