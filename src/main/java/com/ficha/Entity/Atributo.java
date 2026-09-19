package com.ficha.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "atributo")
public class Atributo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_atri")
    private Integer idAtri;

    @Column(name = "descricao", nullable = false, length = 50, unique = true)
    private String descricao;


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
