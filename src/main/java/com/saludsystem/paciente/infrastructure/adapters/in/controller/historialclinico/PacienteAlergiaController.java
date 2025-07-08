package com.saludsystem.paciente.infrastructure.adapters.in.controller.historialclinico;

import com.saludsystem.paciente.application.dto.res.historialclinico.PacienteAlergiaResponse;
import com.saludsystem.paciente.application.dto.req.historialclinico.PacienteAlergiaRequest;
import com.saludsystem.paciente.infrastructure.adapters.in.response.HistorialClinico.PacienteAlergiaListResponse;
import com.saludsystem.shared.application.service.GenericService;
import com.saludsystem.shared.infrastructure.adapters.in.controller.GenericController;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "PacientesAlergias")
@RestController
@RequestMapping("/api/Pacientes/Alergias")
public class PacienteAlergiaController extends GenericController<PacienteAlergiaRequest, PacienteAlergiaResponse, UUID> {

    protected PacienteAlergiaController(GenericService<PacienteAlergiaRequest, PacienteAlergiaResponse, UUID> genericService) {
        super(genericService);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PacienteAlergiaListResponse.class)))
    })
    public ListResponse<PacienteAlergiaResponse> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}