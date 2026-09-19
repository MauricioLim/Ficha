package com.ficha.Entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "inventario")
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inv")
    private Integer idInv;

    @Column(name = "peso_limite", nullable = false, precision = 10, scale = 2)
    private BigDecimal pesoLimite = BigDecimal.ZERO;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_per", nullable = false, unique = true)
    private Personagem personagem;

    @OneToMany(mappedBy = "inventario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemInventario> itens = new ArrayList<>();

    public void adicionarItem(Item item, int qtd) {
        itens.add(new ItemInventario(item, this, qtd));
    }

    public List<ItemInventario> getItens() {
        return itens;
    }

    public Integer getIdInv() {
        return idInv;
    }

    public void setIdInv(Integer idInv) {
        this.idInv = idInv;
    }

    public BigDecimal getPesoLimite() {
        return pesoLimite;
    }

    public void setPesoLimite(BigDecimal pesoLimite) {
        this.pesoLimite = pesoLimite;
    }

    public Personagem getPersonagem() {
        return personagem;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }
}
