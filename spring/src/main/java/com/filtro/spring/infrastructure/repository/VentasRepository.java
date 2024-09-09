package com.filtro.spring.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.filtro.spring.domain.entity.ventas;

public interface VentasRepository extends JpaRepository<ventas, Long> {

}
