package com.ficha.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "proficiencia")
public class Proficiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proe")
    private Integer idProe;

    @Column(name = "descricao", length = 150, nullable = false, unique = true)
    private String descricao;

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
