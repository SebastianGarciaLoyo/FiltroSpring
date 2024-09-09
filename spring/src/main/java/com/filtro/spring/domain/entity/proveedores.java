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
@Table(name = "proveedor")
public class proveedores {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String nombre;

    @Column(columnDefinition = "BIGINT", nullable = false)
    private Integer contacto;

    @Column(columnDefinition = "VARCHAR(100)", nullable = false)
    private String email;

    @Column(columnDefinition = "BIGINT", nullable = false)
    private Integer telefono;

    @ManyToOne
    @JoinColumn(name = "ciudad_id")
    private ciudades ciudades;

    public proveedores() {
    }

    public proveedores(Long id, String nombre, Integer contacto, String email, Integer telefono,
            com.filtro.spring.domain.entity.ciudades ciudades) {
        this.id = id;
        this.nombre = nombre;
        this.contacto = contacto;
        this.email = email;
        this.telefono = telefono;
        this.ciudades = ciudades;
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

    public Integer getContacto() {
        return contacto;
    }

    public void setContacto(Integer contacto) {
        this.contacto = contacto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public ciudades getCiudades() {
        return ciudades;
    }

    public void setCiudades(ciudades ciudades) {
        this.ciudades = ciudades;
    }

    

}
