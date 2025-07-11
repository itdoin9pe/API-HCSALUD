package com.saludsystem.infrastructure.rest.controller.paciente.historialclinico.evolucion;

import com.saludsystem.application.dto.get.historialclinico.evolucion.EvolucionDTO;
import com.saludsystem.application.dto.post.historialclinico.evolucion.CrearEvolucionDTO;
import com.saludsystem.application.dto.put.historialclinico.evolucion.ActualizarEvolucionDTO;
import com.saludsystem.application.service.historialclinico.evolucion.EvolucionService;
import com.saludsystem.infrastructure.adapters.in.response.evolucion.EvolucionListResponse;
import com.shared.infrastructure.adapters.in.response.ApiResponse;
import com.shared.infrastructure.adapters.in.response.ListResponse;
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
    public ApiResponse stored(@Valid @RequestBody CrearEvolucionDTO crearEvolucionDTO) {
        return evolucionService.saveEvolucion(crearEvolucionDTO);
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

    @GetMapping("/GetById/{notaEvolucionId}")
    public EvolucionDTO getById(@PathVariable("notaEvolucionId") UUID pacienteEvolucionId) {
        return evolucionService.getEvolucionById(pacienteEvolucionId);
    }

    @PutMapping("/Update/{notaEvolucionId}")
    public ApiResponse update(@PathVariable("notaEvolucionId") UUID pacienteEvolucionId,
                              @RequestBody ActualizarEvolucionDTO actualizarEvolucionDTO) {
        return evolucionService.updateEvolucion(pacienteEvolucionId, actualizarEvolucionDTO);
    }

    @DeleteMapping("/Delete/{notaEvolucionId}")
    public ApiResponse destroy(@PathVariable("notaEvolucionId") UUID pacienteEvolucionId) {
        return evolucionService.deleteEvolucion(pacienteEvolucionId);
    }
}