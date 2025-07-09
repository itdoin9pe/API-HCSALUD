package com.saludsystem.paciente.infrastructure.adapters.in.controller;

import com.saludsystem.paciente.application.dto.get.DiagnosticoDTO;
import com.saludsystem.paciente.application.dto.post.CrearDiagnosticoDTO;
import com.saludsystem.paciente.application.dto.put.ActualizarDiagnosticoDTO;
import com.saludsystem.paciente.infrastructure.adapters.in.response.DiagnosticoListResponse;
import com.saludsystem.shared.application.service.GenericService;
import com.saludsystem.shared.infrastructure.adapters.in.controller.GenericController;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "PacientesDiagnosticos")
@RestController
@RequestMapping("/api/Pacientes/Diagnosticos")
public class DiagnosticoController extends GenericController<DiagnosticoDTO, CrearDiagnosticoDTO,
        ActualizarDiagnosticoDTO, UUID> {

    protected DiagnosticoController(
            GenericService<DiagnosticoDTO, CrearDiagnosticoDTO, ActualizarDiagnosticoDTO, UUID> genericService) {
        super(genericService);
    }

    @Override
    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = DiagnosticoListResponse.class)))
    })
    public ListResponse<DiagnosticoDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}