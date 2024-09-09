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
@Table(name = "venta")
public class ventas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "DATE", nullable = false)
    private Date fecha;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private clientes clientes;

    public ventas() {
    }

    public ventas(Long id, Date fecha, com.filtro.spring.domain.entity.clientes clientes) {
        this.id = id;
        this.fecha = fecha;
        this.clientes = clientes;
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

    public clientes getClientes() {
        return clientes;
    }

    public void setClientes(clientes clientes) {
        this.clientes = clientes;
    }

    
}
