package com.saludsystem.infrastructure.rest.controller.catalogo.query;

import com.saludsystem.application.catalogo.dtos.get.EspecialidadDTO;
import com.saludsystem.application.catalogo.query.getAll.EspecialidadAllHandler;
import com.saludsystem.application.catalogo.query.getById.EspecialidadByIdHandler;
import com.saludsystem.application.catalogo.response.EspecialidadListResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

public class EspecialidadQueryController {

    private final EspecialidadByIdHandler byIdHandler;
    private final EspecialidadAllHandler allHandler;

    public EspecialidadQueryController(EspecialidadByIdHandler byIdHandler, EspecialidadAllHandler allHandler) {
        this.byIdHandler = byIdHandler;
        this.allHandler = allHandler;
    }

    @GetMapping("/GetById/{id}")
    public EspecialidadDTO getById(@PathVariable UUID id) {
        return byIdHandler.execute(id);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = EspecialidadListResponse.class)))
    })
    public List<EspecialidadDTO> getAllPaginated(UUID hospitalId, int page, int rows) {
        return allHandler.execute(hospitalId, page, rows);
    }
}