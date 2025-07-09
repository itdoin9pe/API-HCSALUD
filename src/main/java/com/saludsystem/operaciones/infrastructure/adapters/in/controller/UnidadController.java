package com.saludsystem.operaciones.infrastructure.adapters.in.controller;

import com.saludsystem.operaciones.application.dto.get.UnidadDTO;
import com.saludsystem.operaciones.application.dto.post.CrearUnidadDTO;
import com.saludsystem.operaciones.application.dto.put.ActualizarUnidadDTO;
import com.saludsystem.operaciones.infrastructure.adapters.in.response.UnidadListResponse;
import com.saludsystem.shared.application.service.GenericService;
import com.saludsystem.shared.infrastructure.adapters.in.controller.GenericController;
import com.saludsystem.shared.infrastructure.adapters.in.response.ListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Unidades")
@RestController
@RequestMapping("/api/Unidades")
public class UnidadController extends GenericController<UnidadDTO, CrearUnidadDTO, ActualizarUnidadDTO, UUID> {

    protected UnidadController(GenericService<UnidadDTO, CrearUnidadDTO, ActualizarUnidadDTO, UUID> genericService) {
        super(genericService);
    }

    @Override
    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operación exitosa",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UnidadListResponse.class)))
    })
    public ListResponse<UnidadDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return super.getAllPaginated(hospitalId, page, rows);
    }
}