package com.filtro.spring.application.services;

import java.util.List;

import com.filtro.spring.domain.entity.ventas;

public interface IVentasService {
    List<ventas> findAll();
    ventas save(ventas ventas);
    ventas update(ventas ventas);
    void deleteById(Long id);
    
}
