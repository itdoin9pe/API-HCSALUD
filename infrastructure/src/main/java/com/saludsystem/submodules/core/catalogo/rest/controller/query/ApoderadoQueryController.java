package com.saludsystem.submodules.core.catalogo.rest.controller.query;

import com.saludsystem.submodules.catalogo.model.dto.ApoderadoDTO;
import com.saludsystem.submodules.catalogo.query.getAll.ApoderadoAllHandler;
import com.saludsystem.submodules.catalogo.query.getById.ApoderadoByIdHandler;
import com.saludsystem.submodules.catalogo.response.ApoderadoListResponse;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Apoderados")
@RestController
@RequestMapping("/api/Apoderados")
public class ApoderadoQueryController {

    private final ApoderadoAllHandler allHandler;
    private final ApoderadoByIdHandler byIdHandler;

    public ApoderadoQueryController(ApoderadoAllHandler allHandler, ApoderadoByIdHandler byIdHandler) {
        this.allHandler = allHandler;
        this.byIdHandler = byIdHandler;
    }

    @GetMapping("/GetById/{apoderadoId}")
    public ApoderadoDTO getById(@PathVariable UUID apoderadoId) {
        return byIdHandler.execute(apoderadoId);
    }

    @GetMapping("/GetAll")
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200",
                    description = "Operación exitosa", content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = ApoderadoListResponse.class)))
    })
    public ListResponse<ApoderadoDTO> getAll(
            @RequestParam UUID hospitalId,
            @RequestParam(name = "Page") int page, @RequestParam(name = "Rows") int rows) {
        return allHandler.execute(hospitalId, new PaginationRequest(page, rows));
    }
}
