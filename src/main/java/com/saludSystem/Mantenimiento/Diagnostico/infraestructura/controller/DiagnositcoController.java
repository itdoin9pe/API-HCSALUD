package com.saludSystem.Mantenimiento.Diagnostico.infraestructura.controller;

import com.saludSystem.Generals.response.ApiResponse;
import com.saludSystem.Generals.response.ListResponse;
import com.saludSystem.Mantenimiento.Diagnostico.aplicacion.dtos.ActualizarDiagnosticoDTO;
import com.saludSystem.Mantenimiento.Diagnostico.aplicacion.dtos.CrearDiagnosticoDTO;
import com.saludSystem.Mantenimiento.Diagnostico.aplicacion.dtos.DiagnosticoDTO;
import com.saludSystem.Mantenimiento.Diagnostico.aplicacion.services.DiagnosticoService;
import com.saludSystem.Mantenimiento.Diagnostico.dominio.DiagnosticoModel;
import com.saludSystem.Mantenimiento.Diagnostico.dominio.DiagnosticoResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Diagnosticos")
@RestController
@RequestMapping("/api/Diagnosticos")
public class DiagnositcoController {

    private final DiagnosticoService diagnosticoService;

    public DiagnositcoController(DiagnosticoService diagnosticoService) {
        this.diagnosticoService = diagnosticoService;
    }

    @PostMapping("/SaveDiagnostico")
    public ApiResponse stored(@Valid @RequestBody CrearDiagnosticoDTO crearDiagnosticoDTO) {
        return diagnosticoService.saveDiagnostico(crearDiagnosticoDTO);
    }

    @GetMapping("/GetAllDiagnostico")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = DiagnosticoResponse.class)))
    })
    public ListResponse<DiagnosticoDTO> getAllPage(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId,
            @RequestParam(name = "Page") int page, @RequestParam(name = "Rows") int rows) {
        return diagnosticoService.getAllDiagnostico(hospitalId, page, rows);
    }

    @GetMapping("/GetDiagnosticoList")
    public ResponseEntity<List<DiagnosticoDTO>> getAllList() {
        return ResponseEntity.ok(diagnosticoService.getDiagnosticoList());
    }

    @GetMapping("/GetDiagnostico/{diagnosticoId}")
    public DiagnosticoDTO getById(@PathVariable UUID diagnosticoId) {
        return diagnosticoService.getDiagnosticoById(diagnosticoId);
    }

    @PutMapping("/UpdateDiagnostico/{diagnosticoId}")
    public ApiResponse update(@PathVariable UUID diagnosticoId, @RequestBody ActualizarDiagnosticoDTO actualizarDiagnosticoDTO) {
        return diagnosticoService.updateDiagnostico(diagnosticoId, actualizarDiagnosticoDTO);
    }

    @DeleteMapping("/DeleteDiagnostico/{diagnosticoId}")
    public ApiResponse destroy(@PathVariable UUID diagnosticoId) {
        return diagnosticoService.deleteDiagnostico(diagnosticoId);
    }

    @GetMapping("/GetDiagnosticosFiltradosPorRol")
    public ResponseEntity<List<DiagnosticoDTO>> getDiagnosticosFiltradosPorRol() {
        return ResponseEntity.ok(diagnosticoService.getDiagnosticosFiltradosPorRol());
    }

}