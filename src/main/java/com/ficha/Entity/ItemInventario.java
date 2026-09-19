package com.ficha.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "item_inventario")
public class ItemInventario {

    @EmbeddedId
    private ItemInventarioId id = new ItemInventarioId();

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn (name = "id_item")
    @MapsId("idItem")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn (name = "id_inv")
    @MapsId("idInv")
    private Inventario inventario;

    @Column(name = "qtd_item", nullable = false)
    private Integer qtdItem = 1;

    public ItemInventario() {
    }

    public ItemInventario(Item item, Inventario inventario, Integer qtdItem) {
        this.item = item;
        this.inventario = inventario;
        this.qtdItem = qtdItem;
    }

    public ItemInventarioId getId() {
        return id;
    }

    public void setId(ItemInventarioId id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public Integer getQtdItem() {
        return qtdItem;
    }

    public void setQtdItem(Integer qtdItem) {
        this.qtdItem = qtdItem;
    }
}


