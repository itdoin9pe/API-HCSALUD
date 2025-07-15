package com.saludsystem.submodules.rest.controller.catalogo.query;

import com.saludsystem.submodules.catalogo.dtos.get.EspecialidadDTO;
import com.saludsystem.submodules.catalogo.query.getAll.EspecialidadAllHandler;
import com.saludsystem.submodules.catalogo.query.getById.EspecialidadByIdHandler;
import com.saludsystem.submodules.catalogo.response.EspecialidadListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Especialidades")
@RestController
@RequestMapping("/api/Especialidades")
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
    public List<EspecialidadDTO> getAllPaginated(
            @RequestParam UUID hospitalId, @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer rows) {
        return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
    }
}