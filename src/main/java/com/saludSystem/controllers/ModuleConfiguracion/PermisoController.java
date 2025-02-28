package com.saludSystem.controllers.ModuleConfiguracion;

import com.saludSystem.dtos.configuration.Permiso.ActualizarPermisoDTO;
import com.saludSystem.dtos.configuration.Permiso.CrearPermisoDTO;
import com.saludSystem.dtos.configuration.Permiso.PermisoDTO;
import com.saludSystem.dtos.responses.ApiResponse;
import com.saludSystem.dtos.responses.Configuration.PermisoResponse;
import com.saludSystem.dtos.responses.ListResponse;
import com.saludSystem.services.modules.configuration.Permiso.PermisoService;
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