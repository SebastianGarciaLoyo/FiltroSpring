package com.filtro.spring.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.filtro.spring.domain.entity.bicicletas;

@Repository
public interface BicicletaRepository extends JpaRepository<bicicletas, Long> {

    
}