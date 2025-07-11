package com.saludsystem.infrastructure.web.restclient.catalogo.command;

import com.saludsystem.catalogo.application.dtos.get.EspecialidadDTO;
import com.saludsystem.catalogo.application.dtos.post.CrearEspecialidadDTO;
import com.saludsystem.catalogo.application.dtos.put.ActualizarEspecialidadDTO;
import com.saludsystem.shared.application.service.GenericService;
import com.saludsystem.shared.infrastructure.adapters.in.controller.GenericController;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import com.saludsystem.catalogo.infrastructure.adapters.in.response.EspecialidadListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Especialidades")
@RestController
@RequestMapping("/api/Especialidades")
public class EspecialidadCommandController extends GenericController<EspecialidadDTO, CrearEspecialidadDTO,
        ActualizarEspecialidadDTO, UUID> {

    protected EspecialidadCommandController(GenericService<EspecialidadDTO,
            CrearEspecialidadDTO, ActualizarEspecialidadDTO, UUID> genericService) {
        super(genericService);
    }

    @Override
    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = EspecialidadListResponse.class)))
    })
    public ListResponse<EspecialidadDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}