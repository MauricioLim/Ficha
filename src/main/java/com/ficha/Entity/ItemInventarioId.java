package com.ficha.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ItemInventarioId implements Serializable {
    @Column(name = "id_inv")
    private Integer idInv;

    @Column(name = "id_item")
    private Integer idItem;

    public ItemInventarioId() {
    }

    public ItemInventarioId(Integer idInv, Integer idItem) {
        this.idInv = idInv;
        this.idItem = idItem;
    }

    public Integer getIdInv() {
        return idInv;
    }

    public void setIdInv(Integer idInv) {
        this.idInv = idInv;
    }

    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ItemInventarioId that)){
            return false;
        }

        return Objects.equals(idItem, that.idItem) && Objects.equals(idInv, that.idInv);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idInv, idItem);
    }
}
