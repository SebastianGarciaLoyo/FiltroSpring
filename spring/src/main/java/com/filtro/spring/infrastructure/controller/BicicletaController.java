package com.filtro.spring.infrastructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filtro.spring.application.services.IBicicletaServices;
import com.filtro.spring.domain.entity.bicicletas;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/bicicleta")
public class BicicletaController {

    private final IBicicletaServices bicicletaServices;

    @Autowired
    public BicicletaController(IBicicletaServices bicicletaServices) {
        this.bicicletaServices = bicicletaServices;
    }

    @GetMapping
    public List<bicicletas> getAllBicicletas() {
        return bicicletaServices.findAll();
    }
    
    @PostMapping
    public ResponseEntity<bicicletas> createBicicleta(@RequestBody bicicletas bicicletas) {
        bicicletas savedBicicletas = bicicletaServices.save(bicicletas);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBicicletas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<bicicletas> updateBicicleta(@PathVariable Long id, @RequestBody bicicletas bicicletas) {
        bicicletas.setId(id);
        try{
            bicicletas updateBicicletas = bicicletaServices.update(bicicletas);
            return ResponseEntity.ok(updateBicicletas);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBicicleta(@PathVariable Long id) {
        try{
            bicicletaServices.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    
}
