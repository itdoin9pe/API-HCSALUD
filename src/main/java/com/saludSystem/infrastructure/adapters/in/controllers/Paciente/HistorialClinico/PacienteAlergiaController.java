package com.saludSystem.infrastructure.adapters.in.controllers.Paciente.HistorialClinico;

import com.saludSystem.application.dtos.Paciente.GET.PacienteAlergiaDTO;
import com.saludSystem.application.dtos.Paciente.POST.CrearPacienteAlergiaDTO;
import com.saludSystem.application.dtos.Paciente.PUT.ActualizarPacienteAlergiaDTO;
import com.saludSystem.application.services.Paciente.PacienteAlergiaService;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.in.response.Paciente.HistorialClinico.PacienteAlergiaResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "PacientesAlergias")
@RestController
@RequestMapping("/api/PacientesAlergias")
public class PacienteAlergiaController {

    private final PacienteAlergiaService pacienteAlergiaService;

    public PacienteAlergiaController(PacienteAlergiaService pacienteAlergiaService) {
        this.pacienteAlergiaService = pacienteAlergiaService;
    }

    @PostMapping("/SavePacienteAlergia")
    public ApiResponse stored(@Valid @RequestBody CrearPacienteAlergiaDTO crearPacienteAlergiaDTO) {
        return pacienteAlergiaService.savePacienteAlergia(crearPacienteAlergiaDTO);
    }

    @GetMapping("/GetAllPacienteAlergia")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PacienteAlergiaResponse.class)))
    })
    public ListResponse<PacienteAlergiaDTO> getAllPage(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId,
            @RequestParam(name = "Page") int page, @RequestParam(name = "Rows") int rows) {
        return pacienteAlergiaService.getAllPacienteAlergia(hospitalId, page, rows);
    }

    @GetMapping("/GetPacienteAlergia/{pacienteAlergiaId}")
    public PacienteAlergiaDTO getById(@PathVariable UUID pacienteAlergiaId) {
        return pacienteAlergiaService.getPacienteAlergiaById(pacienteAlergiaId);
    }

    @PutMapping("/UpdatePacienteAlergia/{pacienteAlergiaId}")
    public ApiResponse update(@PathVariable UUID pacienteAlergiaId, @RequestBody ActualizarPacienteAlergiaDTO actualizarPacienteAlergiaDTO) {
        return pacienteAlergiaService.updatePacienteAlergia(pacienteAlergiaId, actualizarPacienteAlergiaDTO);
    }

    @DeleteMapping("/DeletePacienteAlergia/{pacienteAlergiaId}")
    public ApiResponse destroy(@PathVariable UUID pacienteAlergiaId) {
        return pacienteAlergiaService.deletePacienteAlergia(pacienteAlergiaId);
    }

}