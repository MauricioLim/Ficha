package com.ficha.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @ManyToMany
    @JoinTable(name = "personagem_protecao", joinColumns = @JoinColumn(name = "id_per"),
            inverseJoinColumns = @JoinColumn(name = "id_protecao"))
    private Set<Protecao> protecoes = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "personagem_resistencia", joinColumns = @JoinColumn(name = "id_per"),
            inverseJoinColumns = @JoinColumn(name = "id_res"))
    private Set<Resistencia> resistencias = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "personagem_proficiencia", joinColumns = @JoinColumn(name = "id_per"),
            inverseJoinColumns = @JoinColumn(name = "id_proe"))
    private Set<Proficiencia> proficiencias = new HashSet<>();

    public Set<Protecao> getProtecoes() {
        return protecoes;
    }

    public void setProtecoes(Set<Protecao> protecoes) {
        this.protecoes = protecoes;
    }

    public Set<Resistencia> getResistencias() {
        return resistencias;
    }

    public void setResistencias(Set<Resistencia> resistencias) {
        this.resistencias = resistencias;
    }

    public Set<Proficiencia> getProficiencias() {
        return proficiencias;
    }

    public void setProficiencias(Set<Proficiencia> proficiencias) {
        this.proficiencias = proficiencias;
    }

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
