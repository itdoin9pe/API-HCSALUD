package com.saludSystem.Configuracion.Permisos.infraestructura.controller;

import com.saludSystem.Configuracion.Permisos.aplicacion.dtos.ActualizarPermisoDTO;
import com.saludSystem.Configuracion.Permisos.aplicacion.dtos.CrearPermisoDTO;
import com.saludSystem.Configuracion.Permisos.aplicacion.dtos.PermisoDTO;
import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Configuracion.Permisos.dominio.PermisoResponse;
import com.saludSystem.Generals.response.ListResponse;
import com.saludSystem.Configuracion.Permisos.aplicacion.services.PermisoService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Permisos")
@RestController
@RequestMapping("/api/Permisos")
public class PermisoController {

    private final PermisoService permisoService;

    public PermisoController(PermisoService permisoService) {
        this.permisoService = permisoService;
    }

    @PostMapping("/SavePermiso")
    public ApiResponse stored(@RequestBody @Valid CrearPermisoDTO crearPermisoDTO) {
        return permisoService.savePermiso(crearPermisoDTO);
    }

    @GetMapping("/GetPermiso/{permisoId}")
    public PermisoDTO permisoGetById(@PathVariable UUID permisoId) {
        return permisoService.getPermisoById(permisoId);
    }

    @GetMapping("/GetAllPermiso")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PermisoResponse.class)))
    })
    public ListResponse<PermisoDTO> getAllPage(
            @RequestParam(name = "hospitalId") UUID hospitalId,
            @RequestParam(name = "Page") int page, @RequestParam(name = "Rows") int rows) {
        return permisoService.getAllPermisos(hospitalId, page, rows);
    }

    @PutMapping("/UpdatePermiso/{permisoId}")
    public ApiResponse updated(@PathVariable UUID permisoId, @RequestBody  ActualizarPermisoDTO actualizarPermisoDTO) {
        return permisoService.updatePermiso(permisoId, actualizarPermisoDTO);
    }
    
    @DeleteMapping("/DeletePermiso/{permisoId}")
    public ApiResponse destroy(@PathVariable UUID permisoId) {
        return permisoService.deletePermiso(permisoId);
    }

}