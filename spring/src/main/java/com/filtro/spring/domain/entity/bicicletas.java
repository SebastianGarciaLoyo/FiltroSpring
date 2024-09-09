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
@Table(name = "bicicleta")
public class bicicletas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "DECIMAL(10,2)", nullable = false)
    private Double precio;

    @Column(columnDefinition = "INT", nullable = false)
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "marca_id")
    private marca marca;

    @ManyToOne
    @JoinColumn(name = "modelo_id")
    private modelo modelo;

    public bicicletas() {
    }

    public bicicletas(Long id, Double precio, Integer stock, com.filtro.spring.domain.entity.marca marca,
            com.filtro.spring.domain.entity.modelo modelo) {
        this.id = id;
        this.precio = precio;
        this.stock = stock;
        this.marca = marca;
        this.modelo = modelo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public marca getMarca() {
        return marca;
    }

    public void setMarca(marca marca) {
        this.marca = marca;
    }

    public modelo getModelo() {
        return modelo;
    }

    public void setModelo(modelo modelo) {
        this.modelo = modelo;
    }

    
}
