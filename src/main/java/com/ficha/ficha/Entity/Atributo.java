package com.ficha.ficha.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "atributo")
public class Atributo {
    //id_atri int primary key,
    //    descricao varchar(50) not null,
    //    valor int not null

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_atri")
    private Integer idAtri;

    private String descricao;
    private int valor;

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

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
