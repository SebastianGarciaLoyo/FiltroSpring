package com.filtro.spring.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "detalles_compra")
public class detalles_compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "INT", nullable = false)
    private Integer cantidad;

    @Column(columnDefinition = "DECIMAL(10,2)", nullable = false)
    private Double precio_unitario;

    @ManyToOne
    @JoinColumn(name = "compra_id")
    private compras compras;

    @ManyToOne
    @JoinColumn(name = "repuesto_id")
    private repuestos repuestos;

    public detalles_compra() {
    }

    public detalles_compra(Long id, Integer cantidad, Double precio_unitario,
            com.filtro.spring.domain.entity.compras compras, com.filtro.spring.domain.entity.repuestos repuestos) {
        this.id = id;
        this.cantidad = cantidad;
        this.precio_unitario = precio_unitario;
        this.compras = compras;
        this.repuestos = repuestos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(Double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public compras getCompras() {
        return compras;
    }

    public void setCompras(compras compras) {
        this.compras = compras;
    }

    public repuestos getRepuestos() {
        return repuestos;
    }

    public void setRepuestos(repuestos repuestos) {
        this.repuestos = repuestos;
    }

    

}
