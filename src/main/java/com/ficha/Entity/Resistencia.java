package com.ficha.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "resistencia")
public class Resistencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_res")
    private Integer idRes;

    @Column(name = "descricao", nullable = false, length = 150, unique = true)
    private String descricao;

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
