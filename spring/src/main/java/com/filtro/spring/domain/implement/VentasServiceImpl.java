package com.filtro.spring.domain.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filtro.spring.application.services.IVentasService;
import com.filtro.spring.domain.entity.ventas;
import com.filtro.spring.infrastructure.repository.VentasRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class VentasServiceImpl implements IVentasService {

    @Autowired
    private VentasRepository ventasRepository;

    @Override
    public List<ventas> findAll() {
        return ventasRepository.findAll();
    }

    @Override
    public ventas save(ventas ventas) {
        return ventasRepository.save(ventas);
    }

    @Override
    public ventas update(ventas ventas) {
         if (ventasRepository.existsById(ventas.getId())) {
            return ventasRepository.save(ventas);
        } else {
            throw new EntityNotFoundException("venta no encontrada por id:" + ventas.getId());
        }
    }

    @Override
    public void deleteById(Long id) {
        if (ventasRepository.existsById(id)) {
            ventasRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("venta no encontrada por id:" + id);
        }
    }

}
