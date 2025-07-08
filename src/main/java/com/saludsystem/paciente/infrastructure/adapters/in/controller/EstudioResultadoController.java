package com.saludsystem.paciente.infrastructure.adapters.in.controller;

import com.saludsystem.paciente.application.dto.res.EstudioResultadoResponse;
import com.saludsystem.paciente.application.dto.req.EstudioResultadoRequest;
import com.saludsystem.paciente.application.dto.base.ActualizarEstudioResultadoDTO;
import com.saludsystem.paciente.application.service.EstudioResultadoService;
import com.saludsystem.paciente.infrastructure.adapters.in.response.EstudioResultadoListResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "PacientesEstudiosResultados")
@RestController
@RequestMapping("/api/PacientesEstudiosResultados")
public class EstudioResultadoController {

    private final EstudioResultadoService estudioResultadoService;

    public EstudioResultadoController(EstudioResultadoService estudioResultadoService) {
        this.estudioResultadoService = estudioResultadoService;
    }

    @PostMapping("/SavePacienteEstudioResultado")
    public ApiResponse stored(@Valid @RequestBody EstudioResultadoRequest estudioResultadoRequest) {
        return estudioResultadoService.saveEstudioResultado(estudioResultadoRequest);
    }

    @GetMapping("/GetAllPacienteEstudioResultado")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EstudioResultadoListResponse.class)))
    })
    public ListResponse<EstudioResultadoResponse> getAllPage(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId,
            @RequestParam(name = "Page") int page, @RequestParam(name = "Rows") int rows) {
        return estudioResultadoService.getAllEstudioResultado(hospitalId, page, rows);
    }

    @GetMapping("/GetPacienteEstudioResultado/{pacienteEstudioResultadoId}")
    public EstudioResultadoResponse getById(@PathVariable Long pacienteEstudioResultadoId) {
        return estudioResultadoService.getEstudioResultadoById(pacienteEstudioResultadoId);
    }

    @PutMapping("/UpdatePacienteEstudioResultado/{pacienteEstudioResultadoId}")
    public ApiResponse update(@PathVariable Long pacienteEstudioResultadoId,
                              @RequestBody ActualizarEstudioResultadoDTO actualizarEstudioResultadoDTO) {
        return estudioResultadoService.updateEstudioResultado(pacienteEstudioResultadoId, actualizarEstudioResultadoDTO);
    }

    @DeleteMapping("/DeletePacienteEstudioResultado/{pacienteEstudioResultadoId}")
    public ApiResponse destroy(@PathVariable Long pacienteEstudioResultadoId) {
        return estudioResultadoService.deleteEstudioResultado(pacienteEstudioResultadoId);
    }

}