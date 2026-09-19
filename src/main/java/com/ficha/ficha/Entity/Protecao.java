package com.ficha.ficha.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "protecao")
public class Protecao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_protecao")
    private Integer idProtecao;

    @Column(name = "descricao", nullable = false, length = 150, unique = true)
    private String descricao;

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
