package com.ficha.ficha.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "personagem_pericia")
public class PersonagemPericia {

    @EmbeddedId
    private PersonagemPericiaId id = new PersonagemPericiaId();

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn (name = "id_per")
    @MapsId("idPer")
    private Personagem personagem;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn (name = "per_id")
    @MapsId("perId")
    private Pericia pericia;

    @Column(name = "bonus", nullable = false)
    private int bonus = 0;

    @Column(name = "treino", nullable = false)
    private int treino = 0;

    @Column(name = "outros", nullable = false)
    private int outros = 0;

    public PersonagemPericia() {
    }

    public PersonagemPericia(Personagem personagem, Pericia pericia) {
        this.personagem = personagem;
        this.pericia = pericia;
    }

    public PersonagemPericiaId getId() {
        return id;
    }

    public void setId(PersonagemPericiaId id) {
        this.id = id;
    }

    public Personagem getPersonagem() {
        return personagem;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }

    public Pericia getPericia() {
        return pericia;
    }

    public void setPericia(Pericia pericia) {
        this.pericia = pericia;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getTreino() {
        return treino;
    }

    public void setTreino(int treino) {
        this.treino = treino;
    }

    public int getOutros() {
        return outros;
    }

    public void setOutros(int outros) {
        this.outros = outros;
    }
}
