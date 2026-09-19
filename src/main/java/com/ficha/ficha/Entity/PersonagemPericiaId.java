package com.ficha.ficha.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PersonagemPericiaId implements Serializable {

    @Column(name = "id_per")
    private Integer idPer;

    @Column(name = "per_id")
    private Integer perId;

    public PersonagemPericiaId() {
    }

    public PersonagemPericiaId(Integer idPer, Integer perId) {
        this.idPer = idPer;
        this.perId = perId;
    }

    public Integer getIdPer() {
        return idPer;
    }

    public void setIdPer(Integer idPer) {
        this.idPer = idPer;
    }

    public Integer getPerId() {
        return perId;
    }

    public void setPerId(Integer perId) {
        this.perId = perId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PersonagemPericiaId that)){
            return false;
        }

        return Objects.equals(idPer, that.idPer) && Objects.equals(perId, that.perId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPer, perId);
    }
}
