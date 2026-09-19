package com.ficha.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PersonagemAtributoId implements Serializable {
    @Column(name = "id_per")
    private Integer idPer;

    @Column(name = "id_atri")
    private Integer idAtri;

    public PersonagemAtributoId() {
    }

    public PersonagemAtributoId(Integer idPer, Integer idAtri) {
        this.idPer = idPer;
        this.idAtri = idAtri;
    }

    public Integer getIdPer() {
        return idPer;
    }

    public void setIdPer(Integer idPer) {
        this.idPer = idPer;
    }

    public Integer getIdAtri() {
        return idAtri;
    }

    public void setIdAtri(Integer idAtri) {
        this.idAtri = idAtri;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PersonagemAtributoId that)){
            return false;
        }

        return Objects.equals(idPer, that.idPer) && Objects.equals(idAtri, that.idAtri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPer, idAtri);
    }

}
