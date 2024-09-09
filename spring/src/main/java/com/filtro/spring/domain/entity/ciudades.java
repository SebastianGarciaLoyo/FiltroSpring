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
@Table(name = "ciudad")
public class ciudades {

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

     @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_pais")
    private paises paises;

    public ciudades() {
    }

    public ciudades(Long id, String nombre, com.filtro.spring.domain.entity.paises paises) {
        this.id = id;
        this.nombre = nombre;
        this.paises = paises;
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

    public paises getPaises() {
        return paises;
    }

    public void setPaises(paises paises) {
        this.paises = paises;
    }

    

}
