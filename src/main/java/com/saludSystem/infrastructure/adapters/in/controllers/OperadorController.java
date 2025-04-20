package com.saludSystem.infrastructure.adapters.in.controllers;

import com.saludSystem.application.services.OperadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/operador")
@RequiredArgsConstructor
public class OperadorController {

    private final OperadorService operadorService;

    @PostMapping("/backup")
    public ResponseEntity<String> realizarBackup() {
        operadorService.realizarBackup();
        return ResponseEntity.ok("Backup realizado con éxito");
    }

    @PostMapping("/reparar-tablas")
    public ResponseEntity<String> repararTablas() {
        operadorService.repararTablas();
        return ResponseEntity.ok("Reparación de tablas iniciada");
    }

    @PostMapping("/optimizar-tablas")
    public ResponseEntity<String> optimizarTablas() {
        operadorService.optimizarTablas();
        return ResponseEntity.ok("Optimización de tablas iniciada");
    }
    // otros métodos para reparación y optimización
}