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

import com.filtro.spring.application.services.IDetalles_VentaService;
import com.filtro.spring.domain.entity.detalles_venta;


import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/Detalles")
public class Detalles_VentaController {
    private final IDetalles_VentaService detalles_VentaService;

    @Autowired
    public Detalles_VentaController(IDetalles_VentaService detalles_VentaService) {
        this.detalles_VentaService = detalles_VentaService;
    }

    @GetMapping
    public List<detalles_venta> getAllDetalles_Venta() {
        return detalles_VentaService.findAll();
    }

    @PostMapping
    public ResponseEntity<detalles_venta> createDetalles_Venta(@RequestBody detalles_venta detalles_venta) {
        detalles_venta savedDetalles_Venta = detalles_VentaService.save(detalles_venta);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDetalles_Venta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<detalles_venta> updateDetalles_Venta(@PathVariable Long id, @RequestBody detalles_venta detalles_venta) {
        detalles_venta.setId(id);
        try{
            detalles_venta updateDetalles_venta = detalles_VentaService.update(detalles_venta);
            return ResponseEntity.ok(updateDetalles_venta);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }   
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDetalleVentas(@PathVariable Long id) {
        try{
            detalles_VentaService.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
