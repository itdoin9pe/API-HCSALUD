package com.saludSystem.infrastructure.adapters.in.controllers;

import com.saludSystem.application.services.ServicioService;
import com.saludSystem.domain.model.ServicioEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    @GetMapping("/GetServicio/{id}")
    public ResponseEntity<ServicioEntity> obtenerServicioPorId(@PathVariable Long id) {
        Optional<ServicioEntity> servicio = servicioService.buscarPorId(id);
        return servicio.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/UpdateServicio/{id}")
    public ResponseEntity<ServicioEntity> actualizarServicio(@PathVariable Long id, @RequestBody ServicioEntity servicio) {
        if (!servicioService.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        servicio.setId(id);
        return ResponseEntity.ok(servicioService.guardar(servicio));
    }

    @DeleteMapping("/DeleteServicio/{id}")
    public ResponseEntity<Map<String, String>> eliminarServicio(@PathVariable Long id) {
        if (!servicioService.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build(); // 404
        }
        servicioService.eliminar(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Servicio eliminado correctamente");
        return ResponseEntity.ok(response); // 200 + JSON
    }

}
