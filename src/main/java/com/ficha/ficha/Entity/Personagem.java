package com.ficha.ficha.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "personagem")
public class Personagem {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_per")
    private Integer idPer;

    @Column(name = "nome", length = 150, nullable = false)
    private String nome;

    @Column(name = "origem", length = 150, nullable = false)
    private String origem;

    @Column(name = "classe", length = 150, nullable = false)
    private String classe;

    @Column(name = "vida_total", nullable = false)
    private int vidaTotal;

    @Column(name = "vida_atual", nullable = false)
    private int vidaAtual;

    @Column(name = "sanidade", nullable = false)
    private int sanidade;

    @Column(name = "nex", nullable = false)
    private int nex;

    @Column(name = "deslocamento", nullable = false)
    private int deslocamento;

    @Column(name = "esforco", nullable = false)
    private int esforco;

    @Column(name = "defesa", nullable = false)
    private int defesa = 10;

    @Column(name = "bloqueio", nullable = false)
    private int bloqueio;

    @Column(name = "esquiva", nullable = false)
    private int esquiva;

    @OneToMany(mappedBy = "personagem", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PersonagemAtributo> atributos = new ArrayList<>();

    @OneToMany(mappedBy = "personagem", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PersonagemPericia> pericias = new ArrayList<>();

    public List<PersonagemPericia> getPericias() {
        return pericias;
    }

    public List<PersonagemAtributo> getAtributos() {
        return atributos;
    }

    public void adicionarAtributos(Atributo atributo, int valor) {
        atributos.add(new PersonagemAtributo(this, atributo, valor));
    }

    public void adicionarPericia(Pericia pericia){
        pericias.add(new PersonagemPericia(this, pericia));
    }


    public Integer getIdPer() {
        return idPer;
    }

    public void setIdPer(Integer idPer) {
        this.idPer = idPer;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public int getVidaTotal() {
        return vidaTotal;
    }

    public void setVidaTotal(int vidaTotal) {
        this.vidaTotal = vidaTotal;
    }

    public int getVidaAtual() {
        return vidaAtual;
    }

    public void setVidaAtual(int vidaAtual) {
        this.vidaAtual = vidaAtual;
    }

    public int getSanidade() {
        return sanidade;
    }

    public void setSanidade(int sanidade) {
        this.sanidade = sanidade;
    }

    public int getNex() {
        return nex;
    }

    public void setNex(int nex) {
        this.nex = nex;
    }

    public int getDeslocamento() {
        return deslocamento;
    }

    public void setDeslocamento(int deslocamento) {
        this.deslocamento = deslocamento;
    }

    public int getEsforco() {
        return esforco;
    }

    public void setEsforco(int esforco) {
        this.esforco = esforco;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getBloqueio() {
        return bloqueio;
    }

    public void setBloqueio(int bloqueio) {
        this.bloqueio = bloqueio;
    }

    public int getEsquiva() {
        return esquiva;
    }

    public void setEsquiva(int esquiva) {
        this.esquiva = esquiva;
    }


}
