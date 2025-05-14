package com.saludSystem.infrastructure.adapters.in.controllers.Paciente.Evolucion;

import com.saludSystem.application.dtos.Paciente.GET.Evolucion.EvolucionDTO;
import com.saludSystem.application.dtos.Paciente.POST.Evolucion.CrearEvolucionDTO;
import com.saludSystem.application.dtos.Paciente.PUT.Evolucion.ActualizarEvolucionDTO;
import com.saludSystem.application.services.Paciente.Evolucion.EvolucionService;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.in.response.Paciente.Evolucion.EvolucionResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "PacientesEvoluciones")
@RestController
@RequestMapping("/api/PacientesEvoluciones")
public class EvolucionController {

    private final EvolucionService evolucionService;

    public EvolucionController(EvolucionService evolucionService) {
        this.evolucionService = evolucionService;
    }

    @PostMapping("/SavePacienteEvolucion")
    public ApiResponse stored(@Valid @RequestBody CrearEvolucionDTO crearEvolucionDTO) {
        return evolucionService.saveEvolucion(crearEvolucionDTO);
    }

    @GetMapping("/GetAllPacienteEvolucion")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EvolucionResponse.class)))
    })
    public ListResponse<EvolucionDTO> getAllPage(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId,
            @RequestParam(name = "Page") int page, @RequestParam(name = "Rows") int rows) {
        return evolucionService.getAllEvolucion(hospitalId, page, rows);
    }

    @GetMapping("/GetPacienteEvolucion/{pacienteEvolucionId}")
    public EvolucionDTO getById(@PathVariable UUID pacienteEvolucionId) {
        return evolucionService.getEvolucionById(pacienteEvolucionId);
    }

    @PutMapping("/UpdatePacienteEvolucion/{pacienteEvolucionId}")
    public ApiResponse update(@PathVariable UUID pacienteEvolucionId, @RequestBody ActualizarEvolucionDTO actualizarEvolucionDTO) {
        return evolucionService.updateEvolucion(pacienteEvolucionId, actualizarEvolucionDTO);
    }

    @DeleteMapping("/DeletePacienteEvolucion/{pacienteEvolucionId}")
    public ApiResponse destroy(@PathVariable UUID pacienteEvolucionId) {
        return evolucionService.deleteEvolucion(pacienteEvolucionId);
    }

}