package com.filtro.spring.application.services;

import java.util.List;

import com.filtro.spring.domain.entity.detalles_venta;

public interface IDetalles_VentaService {
    List<detalles_venta> findAll();
    detalles_venta save(detalles_venta detalles_venta);
    detalles_venta update(detalles_venta detalles_venta);
    void deleteById(Long id);
    
}
