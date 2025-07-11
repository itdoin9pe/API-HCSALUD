package com.saludsystem.infrastructure.rest.controller.paciente;

import com.saludsystem.application.dto.get.RecetaDTO;
import com.saludsystem.application.dto.post.CrearRecetaDTO;
import com.saludsystem.application.dto.put.ActualizarRecetaDTO;
import com.saludsystem.infrastructure.adapters.in.response.RecetaListResponse;
import com.configuracion.application.services.GenericService;
import com.configuracion.infrastructure.adapters.in.controller.GenericController;
import com.shared.infrastructure.adapters.in.response.ListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "PacientesRecetas")
@RestController
@RequestMapping("/api/Pacientes/Recetas")
public class RecetaController extends GenericController<RecetaDTO, CrearRecetaDTO, ActualizarRecetaDTO, UUID> {

    protected RecetaController(
            GenericService<RecetaDTO, CrearRecetaDTO, ActualizarRecetaDTO, UUID> genericService) {
        super(genericService);
    }

    @Override
    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = RecetaListResponse.class)))
    })
    public ListResponse<RecetaDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}