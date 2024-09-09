package com.filtro.spring.domain.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.filtro.spring.application.services.IBicicletaServices;
import com.filtro.spring.domain.entity.bicicletas;
import com.filtro.spring.infrastructure.repository.BicicletaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class BicicletaServiceImpl implements IBicicletaServices {

    @Autowired
    private BicicletaRepository bicicletaRepository;

    @Override
    public List<bicicletas> findAll() {
        return bicicletaRepository.findAll();
    }

    @Override
    public bicicletas save(bicicletas bicicletas) {
        return bicicletaRepository.save(bicicletas);
    }

    @Override
    public bicicletas update(bicicletas bicicletas) {
        if (bicicletaRepository.existsById(bicicletas.getId())) {
            return bicicletaRepository.save(bicicletas);
        } else {
            throw new EntityNotFoundException("bicicleta no encontrada por id:" + bicicletas.getId());
        }
        
    }

    @Override
    public void deleteById(Long id) {
        if (bicicletaRepository.existsById(id)) {
            bicicletaRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("bicicleta no encontrada por id:" + id);
        }
    }

}
