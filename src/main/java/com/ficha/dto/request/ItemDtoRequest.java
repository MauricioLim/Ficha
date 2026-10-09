package com.ficha.dto.request;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public class ItemDtoRequest {
    @NotBlank(message = "O nome é obrigatório")
    @Size(max = 150, message = "O nome pode ter no máximo 150 caracteres")
    private String nome;

    @NotNull(message = "O peso é obrigatório")
    @DecimalMin(value = "0.0", message = "O peso não pode ser menor que zero")
    @Digits(integer = 8, fraction = 2, message = "O peso deve ter no máximo 8 dígitos inteiros e 2 casas decimais")
    private BigDecimal pesoItem;

    public ItemDtoRequest(String nome, BigDecimal pesoItem) {
        this.nome = nome;
        this.pesoItem = pesoItem;
    }

    public ItemDtoRequest() {
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
