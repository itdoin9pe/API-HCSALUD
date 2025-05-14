package com.saludSystem.infrastructure.adapters.in.controllers.Paciente;

import com.saludSystem.application.dtos.Paciente.GET.DiagnosticoDTO;
import com.saludSystem.application.dtos.Paciente.POST.CrearDiagnosticoDTO;
import com.saludSystem.application.dtos.Paciente.PUT.ActualizarDiagnosticoDTO;
import com.saludSystem.application.services.Paciente.DiagnosticoService;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.in.response.Paciente.DiagnosticoResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "PacientesDiagnosticos")
@RestController
@RequestMapping("/api/PacientesDiagnosticos")
public class DiagnosticoController {

    private final DiagnosticoService diagnosticoService;

    public DiagnosticoController(DiagnosticoService diagnosticoService) {
        this.diagnosticoService = diagnosticoService;
    }

    @PostMapping("/SavePacienteDiagnostico")
    public ApiResponse stored(@Valid @RequestBody CrearDiagnosticoDTO crearDiagnosticoDTO) {
        return diagnosticoService.saveDiagnostico(crearDiagnosticoDTO);
    }

    @GetMapping("/GetAllPacienteDiagnostico")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = DiagnosticoResponse.class)))
    })
    public ListResponse<DiagnosticoDTO> getAllPage(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId,
            @RequestParam(name = "Page") int page, @RequestParam(name = "Rows") int rows) {
        return diagnosticoService.getAllDiagnotico(hospitalId, page, rows);
    }

    @GetMapping("/GetPacienteDiagnostico/{pacienteDiagnosticoId}")
    public DiagnosticoDTO getById(@PathVariable UUID pacienteDiagnosticoId) {
        return diagnosticoService.getDiagnosticoById(pacienteDiagnosticoId);
    }

    @PutMapping("/UpdatePacienteDiagnostico/{pacienteDiagnosticoId}")
    public ApiResponse update(@PathVariable UUID pacienteDiagnosticoId, @RequestBody ActualizarDiagnosticoDTO actualizarDiagnosticoDTO) {
        return diagnosticoService.updateDiagnostico(pacienteDiagnosticoId, actualizarDiagnosticoDTO);
    }

    @DeleteMapping("/DeletePacienteDiagnostico/{pacienteDiagnosticoId}")
    public ApiResponse destroy(@PathVariable UUID pacienteDiagnosticoId) {
        return diagnosticoService.deleteDiagnostico(pacienteDiagnosticoId);
    }

}