package com.saludSystem.infrastructure.adapters.in.controllers;

import com.saludSystem.application.dtos.Principal.GET.ServicioDTO;
import com.saludSystem.application.dtos.Principal.POST.CrearServicioDTO;
import com.saludSystem.application.dtos.Principal.PUT.ActualizarServicioDTO;
import com.saludSystem.application.services.ServicioService;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
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
    public ResponseEntity<List<ServicioDTO>> listarServicios() {
        return ResponseEntity.ok(servicioService.listarTodos());
    }

    @PostMapping("/SaveServicio")
    public ApiResponse crearServicio(@RequestBody CrearServicioDTO crearServicioDTO) {
        return servicioService.guardar(crearServicioDTO);
    }

    @GetMapping("/GetServicio/{id}")
    public ServicioDTO obtenerServicioPorId(@PathVariable Long id) {
        return servicioService.buscarPorId(id);
    }

    @PutMapping("/UpdateServicio/{id}")
    public ApiResponse actualizarServicio(@PathVariable Long id, @RequestBody ActualizarServicioDTO actualizarServicioDTO) {
        return servicioService.updateServicio(id, actualizarServicioDTO);
    }

    @DeleteMapping("/DeleteServicio/{id}")
    public ApiResponse eliminarServicio(@PathVariable Long id) {
        return servicioService.eliminar(id);
    }

}
