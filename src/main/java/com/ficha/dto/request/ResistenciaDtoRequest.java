package com.ficha.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ResistenciaDtoRequest {
    @NotBlank(message = "A descrição é obrigatório")
    @Size(max = 150, message = "A descrição pode ter no máximo 150 caracteres")
    private String descricao;

    public ResistenciaDtoRequest() {
    }

    public ResistenciaDtoRequest(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
