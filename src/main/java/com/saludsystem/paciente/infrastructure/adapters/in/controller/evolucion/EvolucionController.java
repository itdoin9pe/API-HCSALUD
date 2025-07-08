package com.saludsystem.paciente.infrastructure.adapters.in.controller.evolucion;

import com.saludsystem.paciente.application.dto.res.historialclinico.evolucion.EvolucionDTO;
import com.saludsystem.paciente.application.dto.req.historialclinico.evolucion.EvolucionRequest;
import com.saludsystem.paciente.application.dto.evolucion.ActualizarEvolucionDTO;
import com.saludsystem.paciente.application.service.historialclinico.evolucion.EvolucionService;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.paciente.infrastructure.adapters.in.response.Evolucion.EvolucionListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "PacientesEvoluciones")
@RestController
@RequestMapping("/api/Pacientes/Evoluciones")
public class EvolucionController {

    private final EvolucionService evolucionService;

    public EvolucionController(EvolucionService evolucionService) {
        this.evolucionService = evolucionService;
    }

    @PostMapping("/Save")
    public ApiResponse stored(@Valid @RequestBody EvolucionRequest evolucionRequest) {
        return evolucionService.saveEvolucion(evolucionRequest);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EvolucionListResponse.class)))
    })
    public ListResponse<EvolucionDTO> getAllPage(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId,
            @RequestParam(name = "Page") int page, @RequestParam(name = "Rows") int rows) {
        return evolucionService.getAllEvolucion(hospitalId, page, rows);
    }

    @GetMapping("/GetById/{Id}")
    public EvolucionDTO getById(@PathVariable UUID pacienteEvolucionId) {
        return evolucionService.getEvolucionById(pacienteEvolucionId);
    }

    @PutMapping("/Update/{Id}")
    public ApiResponse update(@PathVariable UUID pacienteEvolucionId,
                              @RequestBody ActualizarEvolucionDTO actualizarEvolucionDTO) {
        return evolucionService.updateEvolucion(pacienteEvolucionId, actualizarEvolucionDTO);
    }

    @DeleteMapping("/Delete/{Id}")
    public ApiResponse destroy(@PathVariable UUID pacienteEvolucionId) {
        return evolucionService.deleteEvolucion(pacienteEvolucionId);
    }
}