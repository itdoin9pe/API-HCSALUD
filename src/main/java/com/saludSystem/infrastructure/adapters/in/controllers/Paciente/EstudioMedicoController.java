package com.saludSystem.infrastructure.adapters.in.controllers.Paciente;

import com.saludSystem.application.dtos.Paciente.GET.EstudioMedicoDTO;
import com.saludSystem.application.dtos.Paciente.POST.CrearEstudioMedicoDTO;
import com.saludSystem.application.dtos.Paciente.PUT.ActualizarEstudioMedicoDTO;
import com.saludSystem.application.services.Paciente.EstudioMedicoService;
import com.saludSystem.infrastructure.adapters.in.response.ApiResponse;
import com.saludSystem.infrastructure.adapters.in.response.ListResponse;
import com.saludSystem.infrastructure.adapters.in.response.Paciente.EstudioMedicoResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "PacientesEstudiosMedicos")
@RestController
@RequestMapping("/api/PacientesEstudiosMedicos")
public class EstudioMedicoController {

    private final EstudioMedicoService estudioMedicoService;

    public EstudioMedicoController(EstudioMedicoService estudioMedicoService) {
        this.estudioMedicoService = estudioMedicoService;
    }

    @PostMapping("/SavePacienteEstudioMedico")
    public ApiResponse stored(@Valid @RequestBody CrearEstudioMedicoDTO crearEstudioMedicoDTO) {
        return estudioMedicoService.saveEstudioMedico(crearEstudioMedicoDTO);
    }

    @GetMapping("/GetAllPacienteEstudioMedico")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EstudioMedicoResponse.class)))
    })
    public ListResponse<EstudioMedicoDTO> getAllPage(
            @RequestParam(name = "hospitalId", required = true) UUID hospitalId,
            @RequestParam(name = "Page") int page, @RequestParam(name = "Rows") int rows) {
        return estudioMedicoService.getAllEstudioMedico(hospitalId, page, rows);
    }

    @GetMapping("/GetPacienteEstudioMedico/{pacienteEstudioMedicoId}")
    public EstudioMedicoDTO getById(@PathVariable Long pacienteEstudioMedicoId) {
        return estudioMedicoService.getEstudioMedicoById(pacienteEstudioMedicoId);
    }

    @PutMapping("/UpdatePacienteEstudioMedico/{pacienteEstudioMedicoId}")
    public ApiResponse update(@PathVariable Long pacienteEstudioMedicoId, @RequestBody ActualizarEstudioMedicoDTO actualizarEstudioMedicoDTO) {
        return estudioMedicoService.updateEstudioMedico(pacienteEstudioMedicoId, actualizarEstudioMedicoDTO);
    }

    @DeleteMapping("/DeletePacienteEstudioMedico/{pacienteEstudioMedicoId}")
    public ApiResponse destroy(@PathVariable Long pacienteEstudioMedicoId) {
        return estudioMedicoService.deleteEstudioMedico(pacienteEstudioMedicoId);
    }

}