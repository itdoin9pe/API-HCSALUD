package com.saludSystem.Operaciones.Unidad.infraestructura.controller;

import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Generals.response.ListResponse;
import com.saludSystem.Mantenimiento.Banco.aplicacion.dtos.ActualizarBancoDTO;
import com.saludSystem.Mantenimiento.Banco.aplicacion.dtos.BancoDTO;
import com.saludSystem.Mantenimiento.Banco.aplicacion.dtos.CrearBancoDTO;
import com.saludSystem.Mantenimiento.Banco.dominio.BancoResponse;
import com.saludSystem.Operaciones.Unidad.aplicacion.dtos.ActualizarUnidadDTO;
import com.saludSystem.Operaciones.Unidad.aplicacion.dtos.CrearUnidadDTO;
import com.saludSystem.Operaciones.Unidad.aplicacion.dtos.UnidadDTO;
import com.saludSystem.Operaciones.Unidad.aplicacion.services.UnidadService;
import com.saludSystem.Operaciones.Unidad.dominio.UnidadResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Unidades")
@RestController
@RequestMapping("/api/Unidades")
public class UnidadController {

    private final UnidadService unidadService;

    public UnidadController(UnidadService unidadService) {
        this.unidadService = unidadService;
    }

    @PostMapping("/SaveUnidad")
    public ApiResponse store(@Valid @RequestBody CrearUnidadDTO crearUnidadDTO) {
        return unidadService.saveUnidad(crearUnidadDTO);
    }

    @GetMapping("/GetAllUnidad")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UnidadResponse.class)))
    })
    public ListResponse<UnidadDTO> getAllPage(
            @RequestParam(name = "hospitalId") UUID hospitalId,
            @RequestParam(name = "Page", defaultValue = "") int page,
            @RequestParam(name = "Rows", defaultValue = "") int rows) {
        return unidadService.getAllUnidad(hospitalId, page, rows);
    }

    @GetMapping("/GetUnidadList")
    public ResponseEntity<List<UnidadDTO>> getAllList() {
        return ResponseEntity.ok(unidadService.getUnidadList());
    }

    @GetMapping("/GetUnidad/{unidadId}")
    public UnidadDTO getById(@PathVariable UUID unidadId) {
        return unidadService.getUnidadById(unidadId);
    }

    @PutMapping("/UpdateUnidad/{unidadId}")
    public ApiResponse update(@PathVariable UUID unidadId, @RequestBody ActualizarUnidadDTO actualizarUnidadDTO) {
        return unidadService.updateUnidad(unidadId, actualizarUnidadDTO);
    }

    @DeleteMapping("/DeleteUnidad/{unidadId}")
    public ApiResponse destroy(@PathVariable UUID unidadId) {
        return unidadService.deleteUnidad(unidadId);
    }

}
