package com.saludsystem.infrastructure.adapters.in.controllers.paciente;

import com.saludsystem.application.dtos.paciente.get.RecetaDTO;
import com.saludsystem.application.dtos.paciente.post.CrearRecetaDTO;
import com.saludsystem.application.dtos.paciente.put.ActualizarRecetaDTO;
import com.saludsystem.application.services.GenericService;
import com.saludsystem.infrastructure.adapters.in.controllers.GenericController;
import com.saludsystem.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.infrastructure.adapters.in.response.paciente.RecetaResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "PacientesRecetas")
@RestController
@RequestMapping("/api/Pacientes/Recetas")
public class RecetaController extends GenericController<RecetaDTO, UUID,
        CrearRecetaDTO, ActualizarRecetaDTO> {

    protected RecetaController(GenericService<RecetaDTO, UUID, CrearRecetaDTO, ActualizarRecetaDTO> genericService) {
        super(genericService);
    }
    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = RecetaResponse.class)))
    })
    public ListResponse<RecetaDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}