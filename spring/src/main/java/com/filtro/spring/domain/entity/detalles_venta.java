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
@Table(name = "detalles_venta")
public class detalles_venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "INT", nullable = false)
    private Integer cantidad;

    @Column(columnDefinition = "DECIMAL(10,2)", nullable = false)
    private Double precio_unitario;

    @ManyToOne
    @JoinColumn(name = "venta_id")
    private ventas ventas;

    @ManyToOne
    @JoinColumn(name = "bicicleta_id")
    private bicicletas bicicletas;

    public detalles_venta() {
    }

    public detalles_venta(Long id, Integer cantidad, Double precio_unitario,
            com.filtro.spring.domain.entity.ventas ventas, com.filtro.spring.domain.entity.bicicletas bicicletas) {
        this.id = id;
        this.cantidad = cantidad;
        this.precio_unitario = precio_unitario;
        this.ventas = ventas;
        this.bicicletas = bicicletas;
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

    public ventas getVentas() {
        return ventas;
    }

    public void setVentas(ventas ventas) {
        this.ventas = ventas;
    }

    public bicicletas getBicicletas() {
        return bicicletas;
    }

    public void setBicicletas(bicicletas bicicletas) {
        this.bicicletas = bicicletas;
    }

    
}
