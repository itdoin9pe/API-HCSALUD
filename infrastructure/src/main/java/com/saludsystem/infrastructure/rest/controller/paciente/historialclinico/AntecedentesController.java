package com.saludsystem.infrastructure.rest.controller.paciente.historialclinico;

import com.saludsystem.application.dto.get.historialclinico.AntecedenteDTO;
import com.saludsystem.application.dto.post.historialclinico.CrearAntecedenteDTO;
import com.saludsystem.application.dto.put.historialclinico.ActualizarAntecedenteDTO;
import com.saludsystem.infrastructure.adapters.in.response.historialclinico.AntecedenteListResponse;
import com.configuracion.application.services.GenericService;
import com.configuracion.infrastructure.adapters.in.controller.GenericController;
import com.shared.infrastructure.adapters.in.response.ListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@Tag(name = "PacientesEnfermedadesActuales")
@RestController
@RequestMapping("/api/Pacientes/EnfermedadesActuales")
public class AntecedentesController extends GenericController<AntecedenteDTO, CrearAntecedenteDTO,
        ActualizarAntecedenteDTO, UUID> {

    protected AntecedentesController(
            GenericService<AntecedenteDTO, CrearAntecedenteDTO, ActualizarAntecedenteDTO, UUID> genericService) {
        super(genericService);
    }

    @Override
    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AntecedenteListResponse.class)))
    })
    public ListResponse<AntecedenteDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}