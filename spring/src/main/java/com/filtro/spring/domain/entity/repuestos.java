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
@Table(name = "repuesto")
public class repuestos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String nombre;

    @Column(columnDefinition = "VARCHAR(200)", nullable = false)
    private String descripcion;

    @Column(columnDefinition = "DECIMAL(10,2)", nullable = false)
    private Double precio;

    @Column(columnDefinition = "INT", nullable = false)
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "proveedor_id")
    private proveedores proveedores;

    @ManyToOne
    @JoinColumn(name = "modelo_id")
    private modelo modelo;

    @ManyToOne
    @JoinColumn(name = "marca_id")
    private marca marca;

    public repuestos() {
    }

    public repuestos(Long id, String nombre, String descripcion, Double precio, Integer stock,
            com.filtro.spring.domain.entity.proveedores proveedores, com.filtro.spring.domain.entity.modelo modelo,
            com.filtro.spring.domain.entity.marca marca) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.proveedores = proveedores;
        this.modelo = modelo;
        this.marca = marca;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public proveedores getProveedores() {
        return proveedores;
    }

    public void setProveedores(proveedores proveedores) {
        this.proveedores = proveedores;
    }

    public modelo getModelo() {
        return modelo;
    }

    public void setModelo(modelo modelo) {
        this.modelo = modelo;
    }

    public marca getMarca() {
        return marca;
    }

    public void setMarca(marca marca) {
        this.marca = marca;
    }

    
}
