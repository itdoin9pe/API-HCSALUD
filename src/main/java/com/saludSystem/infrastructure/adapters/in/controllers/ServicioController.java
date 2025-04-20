package com.saludSystem.infrastructure.adapters.in.controllers;

import com.saludSystem.application.services.ServicioService;
import com.saludSystem.domain.model.ServicioEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Servicios")
public class ServicioController {

    private final ServicioService servicioService;

    public ServicioController(ServicioService servicioService) {
        this.servicioService = servicioService;
    }

    @GetMapping("/GetServicioList")
    public ResponseEntity<List<ServicioEntity>> listarServicios() {
        return ResponseEntity.ok(servicioService.listarTodos());
    }

    @PostMapping("/SaveServicio")
    public ResponseEntity<ServicioEntity> crearServicio(@RequestBody ServicioEntity servicio) {
        return ResponseEntity.ok(servicioService.guardar(servicio));
    }


}
