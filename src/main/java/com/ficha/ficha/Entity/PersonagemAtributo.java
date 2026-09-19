package com.ficha.ficha.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "personagem_atributo")
public class PersonagemAtributo {

    @EmbeddedId
    private PersonagemAtributoId id = new PersonagemAtributoId();

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn (name = "id_per")
    @MapsId("idPer")
    private Personagem personagem;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_atri")
    @MapsId("idAtri")
    private Atributo atributo;

    @Column(name = "valor", nullable = false)
    private int valor;

    public PersonagemAtributo() {
    }

    public PersonagemAtributo(Personagem personagem, Atributo atributo, int valor) {
        this.personagem = personagem;
        this.atributo = atributo;
        this.valor = valor;
    }

    public PersonagemAtributoId getId() {
        return id;
    }

    public void setId(PersonagemAtributoId id) {
        this.id = id;
    }

    public Personagem getPersonagem() {
        return personagem;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }

    public Atributo getAtributo() {
        return atributo;
    }

    public void setAtributo(Atributo atributo) {
        this.atributo = atributo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
