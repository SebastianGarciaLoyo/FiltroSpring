package com.filtro.spring.application.services;

import java.util.List;

import com.filtro.spring.domain.entity.bicicletas;


public interface IBicicletaServices{
    List<bicicletas> findAll();
    bicicletas save(bicicletas bicicletas);
    bicicletas update(bicicletas bicicletas);
    void deleteById(Long id);

}
