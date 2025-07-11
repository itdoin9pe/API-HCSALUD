package com.saludsystem.infrastructure.rest.controller.paciente.historialclinico;

import com.saludsystem.application.dto.get.historialclinico.PacienteAlergiaDTO;
import com.saludsystem.application.dto.post.historialclinico.CrearPacienteAlergiaDTO;
import com.saludsystem.application.dto.put.historialclinico.ActualizarPacienteAlergiaDTO;
import com.saludsystem.infrastructure.adapters.in.response.historialclinico.PacienteAlergiaListResponse;
import com.configuracion.application.services.GenericService;
import com.configuracion.infrastructure.adapters.in.controller.GenericController;
import com.shared.infrastructure.adapters.in.response.ListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "PacientesAlergias")
@RestController
@RequestMapping("/api/Pacientes/Alergias")
public class PacienteAlergiaController extends GenericController<PacienteAlergiaDTO, CrearPacienteAlergiaDTO,
        ActualizarPacienteAlergiaDTO, UUID> {

    protected PacienteAlergiaController(GenericService<PacienteAlergiaDTO, CrearPacienteAlergiaDTO,
                ActualizarPacienteAlergiaDTO, UUID> genericService) {
        super(genericService);
    }

    @Override
    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = PacienteAlergiaListResponse.class)))
    })
    public ListResponse<PacienteAlergiaDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}