package com.ficha.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="pericia")
public class Pericia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "per_id")
    private Integer perId;

    @Column(name = "nome", nullable = false, length = 150, unique = true)
    private String nome;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_atri", nullable = false)
    private Atributo atributo;

    public Integer getPerId() {
        return perId;
    }

    public void setPerId(Integer perId) {
        this.perId = perId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Atributo getAtributo() {
        return atributo;
    }

    public void setAtributo(Atributo atributo) {
        this.atributo = atributo;
    }
}
