package com.filtro.spring.infrastructure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.filtro.spring.application.services.IVentasService;
import com.filtro.spring.domain.entity.ventas;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/venta")
public class VentasController {
    private final IVentasService ventasService;

    @Autowired
       public VentasController(IVentasService ventasService) {
        this.ventasService = ventasService;
    }

        @GetMapping
    public List<ventas> getAllVentas() {
        return ventasService.findAll();
    }

        @PostMapping
    public ResponseEntity<ventas> createVentas(@RequestBody ventas ventas) {
        ventas savedVentas = ventasService.save(ventas);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedVentas);
    }

        @PutMapping("/{id}")
    public ResponseEntity<ventas> updateVentas(@PathVariable Long id, @RequestBody ventas ventas) {
        ventas.setId(id);
        try{
            ventas updateVentas = ventasService.update(ventas);
            return ResponseEntity.ok(updateVentas);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }   
    }

        @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVentas(@PathVariable Long id) {
        try{
            ventasService.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
