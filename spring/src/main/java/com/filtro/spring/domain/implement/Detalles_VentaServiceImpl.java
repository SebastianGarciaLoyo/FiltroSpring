package com.filtro.spring.domain.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filtro.spring.application.services.IDetalles_VentaService;
import com.filtro.spring.domain.entity.detalles_venta;
import com.filtro.spring.infrastructure.repository.Detalles_VentaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class Detalles_VentaServiceImpl implements IDetalles_VentaService {
    @Autowired
    private Detalles_VentaRepository detalles_VentaRepository;

    @Override
    public List<detalles_venta> findAll() {
        return detalles_VentaRepository.findAll();
    }

    @Override
    public detalles_venta save(detalles_venta detalles_venta) {
        return detalles_VentaRepository.save(detalles_venta);
    }

    @Override
    public detalles_venta update(detalles_venta detalles_venta) {
        if (detalles_VentaRepository.existsById(detalles_venta.getId())) {
            return detalles_VentaRepository.save(detalles_venta);
        } else {
            throw new EntityNotFoundException("detalle de la venta no encontrada por id:" + detalles_venta.getId());
        }
    }

    @Override
    public void deleteById(Long id) {
        if (detalles_VentaRepository.existsById(id)) {
            detalles_VentaRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("detalle de la venta no encontrada por id:" + id);
        }
    }
}
