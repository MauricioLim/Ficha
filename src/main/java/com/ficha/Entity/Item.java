package com.ficha.Entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item")
    private Integer idItem;

    @Column(name = "nome", length = 150, nullable = false)
    private String nome;

    @Column(name = "peso_item", nullable = false, precision = 10, scale = 2)
    private BigDecimal pesoItem = BigDecimal.ZERO;

    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
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
