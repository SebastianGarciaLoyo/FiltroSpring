package com.filtro.spring.domain.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "compra")
public class compras {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "DATE", nullable = false)
    private Date fecha;

    @Column(columnDefinition = "DECIMAL(10,2)", nullable = false)
    private Double total;

    @ManyToOne
    @JoinColumn(name = "proveedor_id")
    private proveedores proveedores;

    public compras(Long id, Date fecha, Double total, com.filtro.spring.domain.entity.proveedores proveedores) {
        this.id = id;
        this.fecha = fecha;
        this.total = total;
        this.proveedores = proveedores;
    }

    public compras() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public proveedores getProveedores() {
        return proveedores;
    }

    public void setProveedores(proveedores proveedores) {
        this.proveedores = proveedores;
    }

    
}
