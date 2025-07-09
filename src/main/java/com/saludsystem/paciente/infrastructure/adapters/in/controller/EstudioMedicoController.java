package com.saludsystem.paciente.infrastructure.adapters.in.controller;

import com.saludsystem.paciente.application.dto.get.EstudioMedicoDTO;
import com.saludsystem.paciente.application.dto.post.CrearEstudioMedicoDTO;
import com.saludsystem.paciente.application.dto.put.ActualizarEstudioMedicoDTO;
import com.saludsystem.paciente.application.service.EstudioMedicoService;
import com.saludsystem.paciente.infrastructure.adapters.in.response.EstudioMedicoListResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ApiResponse;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
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
                            schema = @Schema(implementation = EstudioMedicoListResponse.class)))
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
    public ApiResponse update(@PathVariable Long pacienteEstudioMedicoId,
                              @RequestBody ActualizarEstudioMedicoDTO actualizarEstudioMedicoDTO) {
        return estudioMedicoService.updateEstudioMedico(pacienteEstudioMedicoId, actualizarEstudioMedicoDTO);
    }

    @DeleteMapping("/DeletePacienteEstudioMedico/{pacienteEstudioMedicoId}")
    public ApiResponse destroy(@PathVariable Long pacienteEstudioMedicoId) {
        return estudioMedicoService.deleteEstudioMedico(pacienteEstudioMedicoId);
    }
}