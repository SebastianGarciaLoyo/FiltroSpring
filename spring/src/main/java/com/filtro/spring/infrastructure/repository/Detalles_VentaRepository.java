package com.filtro.spring.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.filtro.spring.domain.entity.detalles_venta;

public interface Detalles_VentaRepository extends JpaRepository<detalles_venta, Long> {

}
